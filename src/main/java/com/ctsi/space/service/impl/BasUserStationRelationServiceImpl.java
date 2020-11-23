package com.ctsi.space.service.impl;


import com.ctsi.core.utils.ThreadPoolsUtil;
import com.ctsi.security.domain.BasOrganization;
import com.ctsi.security.domain.BasUser;
import com.ctsi.security.domain.dto.UserOrgInfoDto;
import com.ctsi.security.service.BasOrganizationService;
import com.ctsi.security.service.BasUserService;
import com.ctsi.security.util.SecurityUtil;
import com.ctsi.space.domain.BasUserStationRelation;
import com.ctsi.space.domain.BasUserStationRelationExample;
import com.ctsi.space.domain.dto.*;
import com.ctsi.space.repository.BasStationRepository;
import com.ctsi.space.repository.BasUserStationRelationRepository;
import com.ctsi.space.service.BasUserStationRelationService;
import com.ctsi.space.task.SyncUserStationRelTask;
import com.ctsi.space.utils.ApiResultUtil;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BasUserStationRelation.
 *
 * @author ctsi-biyi-generator
 */
@Service
public class BasUserStationRelationServiceImpl
        extends StrengthenBaseServiceImpl<BasUserStationRelationRepository, BasUserStationRelation, Long, BasUserStationRelationExample>
        implements BasUserStationRelationService {

    private final static Logger log = LoggerFactory.getLogger(BasUserStationRelationServiceImpl.class);

    private final static Integer ORG = 1;
    private final static Integer STATION = 0;
    private final static String INSERT = "insert";
    private final static String DELETE = "delete";
    private final static int UNIT_OPT_SIZE = 500;
    private final static boolean ENABLED_SYNC = true;

    /**
     * 告警同步接口
     */
    @Value("${userStationRel.syncAlarmUrl}")
    private String URL_ALARM_SYNC_USER_STATION_REL;

    /**
     * 工单同步接口
     */
    @Value("${userStationRel.syncOrderUrl}")
    private String URL_ORDER_SYNC_USER_STATION_REL;

    @Resource
    private BasOrganizationService basOrganizationService;

    @Resource
    private BasStationRepository basStationRepository;

    @Resource
    private BasUserService basUserService;

    /**
     * 获取当前用户账户对应组织及组织对应的下级组织信息和台站信息组成的树，
     * 若userId不为空，则同时设置台站选中
     * 不传userId时，则默认获取当前用户账户对应的树（用于用户新增），
     * 反之则用于用户编辑
     *
     * @return 参上
     *
     * @author lechp
     */
    @Override
    public StationOrgTreeNode getCurUserStationOrgTree(Long userId) {
        Long curUserId = SecurityUtil.getCurrentUserId();
        if (curUserId == null) {
            log.error("获取不到当前用户");
            return null;
        }
        // 查询当前用户所属组织信息
        UserOrgInfoDto curUserOrgInfoDto = basOrganizationService.getUserOrgInfo(curUserId);
        if (curUserOrgInfoDto.getOrgLevel() > 3) {
            // 用户所属组织小于营级别，看不了
            return null;
        }
        UserOrgInfoDto userOrgInfoDto = basOrganizationService.getUserOrgInfo(userId);
        if (userOrgInfoDto != null && userOrgInfoDto.getOrgLevel() > 3) {
            // 指向用户的组织级别小于营级别，看不了
            return null;
        }
        // 递归查询当前用户下属组织、台站信息
        Long orgId = curUserOrgInfoDto.getOrgId();
        StationOrgTreeNode tree = userOrgInfoDtoToStationOrgTreeNode(curUserOrgInfoDto);
        List<StationOrgTreeNode> orgs = basOrganizationService.findChildrenOrg(orgId);
        List<StationOrgTreeNode> stations = basStationRepository.findStationsByOrgId(orgId);
        Set<Long> stationsSelected = null;
        if (userId != null) {
            stationsSelected = new HashSet<>();
            tree.setSelected(false);
            Set<Long> result = r.selectStationIdsByUserId(userId);
            if (result != null) {
                stationsSelected = result;
            }
        }
        // 若userId不为null，查询所有用户台站关联关系设置选中
        loopOrgTree(tree, orgs, stations, stationsSelected);
        cutLevel(tree, 3);
        return tree;
    }

    /**
     * 用户组织信息转组织台站树节点
     *
     * @param userOrgInfoDto 用户组织信息
     *
     * @return 台站组织树节点
     *
     * @author lechp
     */
    private StationOrgTreeNode userOrgInfoDtoToStationOrgTreeNode(UserOrgInfoDto userOrgInfoDto) {
        StationOrgTreeNode node = new StationOrgTreeNode();
        node.setId(userOrgInfoDto.getOrgId());
        node.setName(userOrgInfoDto.getOrgName());
        node.setParentId(userOrgInfoDto.getParentOrgId());
        node.setType(ORG);
        node.setLevel(userOrgInfoDto.getOrgLevel());
        node.setChildren(new ArrayList<>());
        return node;
    }

    /**
     * 递归生成组织、台站树，同时设置台站选中
     *
     * @param stationOrgTreeNode 树
     * @param orgs               组织列表
     * @param stations           台站列表
     * @param stationsSelected   台站选中
     *
     * @return 子树被选中的数目
     *
     * @author lechp
     */
    private Integer loopOrgTree(StationOrgTreeNode stationOrgTreeNode, List<StationOrgTreeNode> orgs,
                                List<StationOrgTreeNode> stations, Set<Long> stationsSelected) {
        Long orgId = stationOrgTreeNode.getId();
        int selectedNum = 0;
        // 查询所有子组织、子台站
        if (stationOrgTreeNode.getChildren() == null) {
            stationOrgTreeNode.setChildren(new ArrayList<>());
        }
        List<StationOrgTreeNode> children = stationOrgTreeNode.getChildren();
        for (StationOrgTreeNode org : orgs) {
            if (org.getParentId().equals(orgId)) {
                org.setType(ORG);
                if (stationsSelected != null) {
                    org.setSelected(false);
                }
                children.add(org);
                selectedNum += loopOrgTree(org, orgs, stations, stationsSelected);
            }
        }
        for (StationOrgTreeNode station : stations) {
            if (station.getParentId().equals(orgId)) {
                if (stationsSelected != null && !stationsSelected.contains(station.getId())) {
                    station.setSelected(false);
                } else {
                    selectedNum += 1;
                }
                station.setType(STATION);
                children.add(station);
            }
        }
        return selectedNum;
    }

    /**
     * 缩小级别
     *
     * @param tree  树
     * @param level 级别
     */
    private List<StationOrgTreeNode> cutLevel(StationOrgTreeNode tree, int level) {
        if (tree == null) {
            return null;
        }
        List<StationOrgTreeNode> children = tree.getChildren();
        if (children == null || children.size() == 0) {
            return null;
        }
        List<StationOrgTreeNode> childrenNew = new ArrayList<>();
        for (StationOrgTreeNode node : children) {
            int type = node.getType();
            if (type == 1) {
                int orgLevel = node.getLevel();
                if (orgLevel > level) {
                    // 上移其下台站
                    List<StationOrgTreeNode> childrenChildren = node.getChildren();
                    if (childrenChildren != null && childrenChildren.size() != 0) {
                        List<StationOrgTreeNode> stations = cutLevel(node, level);
                        if (stations != null && stations.size() > 0) {
                            childrenNew.addAll(stations);
                        }
                    }
                } else {
                    // 等级满足保留
                    cutLevel(node, level);
                    childrenNew.add(node);
                }
            } else {
                // 台站保留
                childrenNew.add(node);
            }
        }
        if (tree.getType() == 1 && tree.getLevel() == level) {
            // 去重
            HashMap<String, StationOrgTreeNode> nodesNotRepeated = new HashMap<>();
            for (StationOrgTreeNode nodeNew : childrenNew) {
                // 类型-ID
                nodesNotRepeated.put(String.format("%d-%d", nodeNew.getType(), nodeNew.getId()), nodeNew);
            }
            childrenNew = new ArrayList<>(nodesNotRepeated.values());
        }
        tree.setChildren(childrenNew);
        return childrenNew;
    }

    /**
     * 保存或新增对应的用户台站关联关系
     *
     * @param userStationRelUpdateDto dto
     *
     * @return 结果
     *
     * @author lechp
     */
    @Override
    @Transactional
    public ApiResult saveOrUpdateUserStationRel(UserStationRelUpdateDto userStationRelUpdateDto) {
        // 本地处理、调工单告警的接口
        Long userId = userStationRelUpdateDto.getUserId();
        List<Long> stationIdsAdd = userStationRelUpdateDto.getStationIdsAdd();
        List<Long> stationIdsDelete = userStationRelUpdateDto.getStationIdsDelete();
        int rows = 0;
        if (stationIdsDelete != null && stationIdsDelete.size() > 0) {
            rows = insertOrDeleteUserStationRelListForStations(userId, userStationRelUpdateDto.getStationIdsDelete(), DELETE);
        }
        if (stationIdsAdd != null && stationIdsAdd.size() > 0) {
            rows = insertOrDeleteUserStationRelListForStations(userId, userStationRelUpdateDto.getStationIdsAdd(), INSERT);
        }
        // 调工单告警的接口
        if (ENABLED_SYNC) {
            SyncUserStationRelTask syncOrderUserStationRelTask =
                    new SyncUserStationRelTask(userStationRelUpdateDto, URL_ORDER_SYNC_USER_STATION_REL);
            SyncUserStationRelTask syncAlarmUserStationRelTask =
                    new SyncUserStationRelTask(userStationRelUpdateDto, URL_ALARM_SYNC_USER_STATION_REL);
            ThreadPoolsUtil.addTask(syncOrderUserStationRelTask);
            ThreadPoolsUtil.addTask(syncAlarmUserStationRelTask);
        }
        return ApiResultUtil.createSuccessApiResult("保存成功", rows);
    }

    /**
     * 用户组织迁移
     * 会将用户之前的台站关联关系清空，然后默认添加上目标组织所有的台站关联
     *
     * @param userStationRelChangeOrgDto dto
     *
     * @return 结果
     *
     * @author lechp
     */
    @Override
    @Transactional
    public ApiResult userStationRelChangeOrg(UserStationRelChangeOrgDto userStationRelChangeOrgDto) {
        Long userId = userStationRelChangeOrgDto.getUserId();
        if (userId == null) {
            log.warn("userId为空");
            return ApiResultUtil.createErrorApiResult("userId为空");
        }
        Long orgId = userStationRelChangeOrgDto.getOrgId();
        if (orgId == null) {
            log.warn("orgId为空");
            return ApiResultUtil.createErrorApiResult("orgId为空");
        }
        BasUser user = basUserService.findOne(userId);
        if (user == null) {
            log.warn("用户不存在");
            return ApiResultUtil.createErrorApiResult("用户不存在");
        }
        BasOrganization organization = basOrganizationService.findOne(orgId);
        if (organization == null) {
            log.warn("组织不存在");
            return ApiResultUtil.createErrorApiResult("组织不存在");
        }
        r.deleteByUserId(userId);
        List<Long> stationIds = basStationRepository.findStationIdsByOrgId(orgId);
        int rows = insertOrDeleteUserStationRelListForStations(userId, stationIds, INSERT);
        // 调工单告警的接口
        if (ENABLED_SYNC) {
            UserStationRelUpdateDto userStationRelUpdateDto = new UserStationRelUpdateDto();
            userStationRelUpdateDto.setUserId(userId);
            userStationRelUpdateDto.setStationIdsAdd(stationIds);
            userStationRelUpdateDto.setStationIdsDelete(new ArrayList<>());
            SyncUserStationRelTask syncOrderUserStationRelTask =
                    new SyncUserStationRelTask(userStationRelUpdateDto, URL_ORDER_SYNC_USER_STATION_REL);
            SyncUserStationRelTask syncAlarmUserStationRelTask =
                    new SyncUserStationRelTask(userStationRelUpdateDto, URL_ALARM_SYNC_USER_STATION_REL);
            ThreadPoolsUtil.addTask(syncOrderUserStationRelTask);
            ThreadPoolsUtil.addTask(syncAlarmUserStationRelTask);
        }
        return ApiResultUtil.createSuccessApiResult("迁移成功", rows);
    }

    /**
     * 分批次插入或删除
     *
     * @param userId     用户ID
     * @param stationIds 台站ID列表
     * @param type       add增加，delete删除
     *
     * @return 行数
     */
    private int insertOrDeleteUserStationRelListForStations(Long userId, List<Long> stationIds, String type) {
        if (!type.equals(INSERT) && !type.equals(DELETE)) {
            throw new RuntimeException("可选操作：insert增加，delete删除");
        }
        int left = stationIds.size();
        int fromIndex = -UNIT_OPT_SIZE;
        int toIndex = 0;
        int affectRows = 0;
        while (left > 0) {
            fromIndex += UNIT_OPT_SIZE;
            toIndex += left >= UNIT_OPT_SIZE ? UNIT_OPT_SIZE : left;
            affectRows += type.equals(INSERT) ?
                    r.insertUserStationRelListForStations(userId, stationIds.subList(fromIndex, toIndex))
                    :
                    r.deleteUserStationRelListFoStations(userId, stationIds.subList(fromIndex, toIndex));
            left -= UNIT_OPT_SIZE;
        }
        return affectRows;
    }

    /**
     * 分批次插入
     *
     * @param stationId 台站ID
     * @param userIds   用户ID列表
     * @param type      add增加，delete删除
     *
     * @return 行数
     */
    private int insertOrDeleteUserStationRelListForUsers(Long stationId, List<Long> userIds, String type) {
        if (!type.equals(INSERT) && !type.equals(DELETE)) {
            throw new RuntimeException("可选操作：insert增加，delete删除");
        }
        int left = userIds.size();
        int fromIndex = -UNIT_OPT_SIZE;
        int toIndex = 0;
        int affectRows = 0;
        while (left > 0) {
            fromIndex += UNIT_OPT_SIZE;
            toIndex += left >= UNIT_OPT_SIZE ? UNIT_OPT_SIZE : left;
            affectRows += type.equals(INSERT) ?
                    r.insertUserStationRelListForUsers(stationId, userIds.subList(fromIndex, toIndex))
                    :
                    r.deleteUserStationRelListForUsers(stationId, userIds.subList(fromIndex, toIndex));
            left -= UNIT_OPT_SIZE;
        }
        return affectRows;
    }

    /**
     * 账户台站关联信息全量查询
     *
     * @return 所有的用户台站关联关系
     *
     * @author lechp
     */
    @Override
    public List<UserStationRelDto> getAllUserStationRel() {
        List<BasUserStationRelation> relations = r.selectAllUserIdStationId();
        Long curUserId = 0L;
        List<UserStationRelDto> userStationRelDtoList = new ArrayList<>();
        for (int i = 0, j = -1; i < relations.size(); i++) {
            Long userId = relations.get(i).getUserId();
            Long stationId = relations.get(i).getStationId();
            if (!userId.equals(curUserId)) {
                curUserId = userId;
                UserStationRelDto userStationRelDto = new UserStationRelDto();
                userStationRelDto.setUserId(curUserId);
                userStationRelDto.setStationIds(new ArrayList<>());
                userStationRelDtoList.add(userStationRelDto);
                j++;
            }
            userStationRelDtoList.get(j).getStationIds().add(stationId);
        }
        return userStationRelDtoList;
    }

    /**
     * 批量更新或删除用户台站关联关系
     *
     * @param userStationRelUpdateStationDto dto
     * @param type                           insert增加，delete删除
     *
     * @return 结果
     *
     * @author lechp
     */
    private ApiResult userStationRelAddOrDeleteStation(UserStationRelUpdateStationDto userStationRelUpdateStationDto,
                                                       String type) {
        if (!type.equals(INSERT) && !type.equals(DELETE)) {
            throw new RuntimeException("可选操作：insert增加，delete删除");
        }
        Long orgId = userStationRelUpdateStationDto.getOrgId();
        if (orgId == null) {
            log.warn("orgId为空");
            return ApiResultUtil.createErrorApiResult("orgId为空");
        }
        Long stationId = userStationRelUpdateStationDto.getStationId();
        if (stationId == null) {
            log.warn("stationId为空");
            return ApiResultUtil.createErrorApiResult("stationId为空");
        }
        String orgPath = basOrganizationService.selectOrgPathByOrgId(orgId);
        List<Long> orgIds = Arrays.stream(orgPath.split("/"))
                .filter(s -> !s.equals(""))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        // 查询这些组织关联的所有用户
        List<Long> userIds = basUserService.selectUserIdsByOrgIds(orgIds);
        int rows = insertOrDeleteUserStationRelListForUsers(stationId, userIds, type);
        // TODO 调工单告警的接口

        return ApiResultUtil.createSuccessApiResult(type.equals(INSERT) ? "增加成功" : "删除成功", rows);
    }

    /**
     * 资源某组织新增台站，对应设置该组织及以上组织的所有用户新增该台站关联关系（同步）
     *
     * @param userStationRelUpdateStationDto dto
     *
     * @return 结果
     *
     * @author lechp
     */
    @Override
    public ApiResult userStationRelAddStation(UserStationRelUpdateStationDto userStationRelUpdateStationDto) {
        return userStationRelAddOrDeleteStation(userStationRelUpdateStationDto, INSERT);
    }

    /**
     * 资源某组织删除台站，对应设置该组织及以上组织的所有用户删除该台站关联关系（同步）
     *
     * @param userStationRelUpdateStationDto dto
     *
     * @return 结果
     *
     * @author lechp
     */
    @Override
    public ApiResult userStationRelDeleteStation(UserStationRelUpdateStationDto userStationRelUpdateStationDto) {
        return userStationRelAddOrDeleteStation(userStationRelUpdateStationDto, DELETE);
    }
}
