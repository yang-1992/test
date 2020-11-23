package com.ctsi.block.service.impl;


import com.ctsi.block.domain.BlockedInfo;
import com.ctsi.block.domain.BlockedInfoExample;
import com.ctsi.block.domain.BlockedSystem;
import com.ctsi.block.domain.dto.*;
import com.ctsi.block.repository.BlockedInfoRepository;
import com.ctsi.block.repository.BlockedSystemRepository;
import com.ctsi.block.service.BlockedInfoService;
import com.ctsi.block.service.BlockedSystemService;
import com.ctsi.block.utils.CommonUtil;
import com.ctsi.block.utils.HttpUtil;
import com.ctsi.space.utils.ApiResultUtil;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BlockedInfo.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BlockedInfoServiceImpl 
	extends StrengthenBaseServiceImpl<BlockedInfoRepository, BlockedInfo, Object, BlockedInfoExample> 
	implements BlockedInfoService {

	@Autowired
	BlockedInfoRepository blockedInfoRepository;
	@Autowired
	BlockedSystemRepository blockedSystemRepository;

	@Autowired
	BlockedSystemService blockedSystemService;

	/**待lv审核*/
	private final static Long BLOCK_STATUS_LV = 101011026001L;
	/**待JD审核*/
	private final static Long BLOCK_STATUS_JD = 101011026002L;
	/**已完成*/
	private final static Long BLOCK_STATUS_COM = 101011026003L;

	/** 索赔状态未申请*/
	private final static String CLAIM_NO = "未申请";

	/**Y级*/
	private final static Long LEVEL_Y = 301L;
	/**L级*/
	private final static Long LEVEL_L = 3L;
	/**JD级*/
	private final static Long LEVEL_JD = 1L;

    /** 审批通过 */
    static final long PASS = 101011028003L;
	/** 审批不通过 */
    static final long NOPASS = 101011028004L;
    /** 待审核 */
    static final long WAIT_APPROVAL= 101011028002L;
    /** 无需审核 */
    static final long NO_APPROVAL = 101011028001L;

    /** 一级级别 */
    static final Long ONE_LEVEL = 101011007004L;

	/** KQ级别 */
	static final Long KQ_LEVEL = 101011007001L;

	/**阻断增加
	 *
	 * @param blockedInfo
	 * @return
	 */
	@Override
	public int blockedInfoInsert(BlockedInfo blockedInfo) {

		//blockedInfo.setBlockedId(PrimaryKeyBuild.createId());	//主键
		//是否删除	默认不删除
		blockedInfo.setIsValid(1101005011001L);
		//阻断时长计算  保留2位小数
		Double blockedHours = blockedDate(blockedInfo);
		blockedInfo.setBlockedDuration(blockedHours);


		//获取当前登录信息
        //TODO 写死的登记人  查表
		Long userId = 333333333L;
		Long orgId = blockedInfoRepository.getOrgIdByuserId(userId);

		//传输系统级别
		Long transLevel = blockedInfo.getTransLevel();

		//阻断状态
		Long blockState = blockedState(orgId,transLevel);
		blockedInfo.setBlockedState(blockState);

		//索赔状态    默认未申请
		blockedInfo.setClaimState(101011027001L);

		//登记信息
        //名
		blockedInfo.setUserId(userId);
        //组织
		blockedInfo.setOrgId(orgId);
        //登记时间
		blockedInfo.setCommitDate(CommonUtil.convertStr2ZonedTime(CommonUtil.getTimeFen(),"yyyy-MM-dd HH:mm"));

		//阻断信息提交
		blockedInfoRepository.insertSelective(blockedInfo);

		//业务影像范围  添加至传输系统表
		affactRangeInsert(blockedInfo,1);

		return 1;
	}

    /**
     * 传输系统增  blockedSystem表
     * @param blockedInfo
     */
	public void affactRangeInsert(BlockedInfo blockedInfo,int datasource){
		//判断此时是光缆段还是台站
		long id = 0L;
		int type = 1;

		if(!CommonUtil.checkIsNullOrEmpty(blockedInfo.getOptSegId())){
			//光缆段
			id = blockedInfo.getOptSegId();
			type = 0;
		}else {
			//台站
			id = blockedInfo.getStationId();
			type = 1;
		}


		//http请求调用
		String url = "http://192.168.203.150:9000/api/getInsertList?";
		String param ="id="+id+"&type="+type;
		String result = HttpUtil.sendPost(url,param);

		List<SystemDto> list_http = new ArrayList<>();
		if(!CommonUtil.checkIsNullOrEmpty(result)) {
			result = result.replace("null","\"\"");
			SystemDto[] s = new Gson().fromJson(result,SystemDto[].class);
			list_http = Arrays.asList(s);
		}

		SystemResult systemResult = new SystemResult();
		systemResult.setBlockedId(blockedInfo.getBlockedId());
		systemResult.setList(list_http);
		systemResult.setType(datasource);

		blockedSystemService.systemInsert(systemResult);
	}

	/**
	 * 阻断查询
	 * @param paramDto
	 * @param page
	 * @return
	 */
	@Override
	public PageInfo<BlockedInfoDto> blockedInfoSelect(BlockedParamDto paramDto, PageInfo page) {

		//TODO 写死的登记人  查表
		Long userId = 222222222L;
		Long orgId_1 = blockedInfoRepository.getOrgIdByuserId(userId);

		//暂时写死级别
		paramDto.setOrgId(orgId_1);

		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<BlockedInfoDto> list = blockedInfoRepository.queryBlockByPage(paramDto);
		//查询传输系统
		if(!CollectionUtils.isEmpty(list)){
			List<Long> blockIdList = list.stream().map((x)-> x.getBlockedId()).collect(Collectors.toList());
			List<BlockedSystem> systemList = blockedSystemRepository.selectSystemByBlockedId(blockIdList);
			Map<Long, String> map = systemList.stream().collect(
					Collectors.groupingBy(
							BlockedSystem::getBlockedId,
							Collectors.mapping(BlockedSystem::getSystemName,
									Collectors.joining(","))));
			Long orgId = paramDto.getOrgId();
			//设置传输系统名称聚合
			list.stream().forEach((x) -> {
				//设置传输系统名称
				x.setSystemName(map.get(x.getBlockedId()));
				//设置权限
				//如果lv级别待审核，Y级别可以编辑和删除
				if(x.getBlockedState().equals(BLOCK_STATUS_LV)){
					if(orgId.equals(LEVEL_Y)){
						x.setEditRight(1);
						x.setDeleteRight(1);
					}else if(orgId.equals(LEVEL_L)){
						x.setApprovalRight(1);
					}
				}
				//如果是JD待审核
				if(x.getBlockedState().equals(BLOCK_STATUS_JD)){
					if(orgId.equals(LEVEL_JD)){
						x.setApprovalRight(1);
					}
				}
				//完成   Y LV 能申请索赔
				if(x.getBlockedState().equals(BLOCK_STATUS_COM)&&x.getClaimState().equals(CLAIM_NO)){
					if(orgId.equals(LEVEL_Y)||orgId.equals(LEVEL_L)){
						x.setClaimRight(1);
					}
				}
			});
		}
		PageInfo<BlockedInfoDto> resultPage = new PageInfo<>(list);
		return resultPage;
	}

	/**组织树查询
	 *
	 * @param orgId
	 * @return
	 */
	@Override
	public List<OrgTree> maintOrgSelect(Long orgId) {
		//仅是组织表里的
		List<OrgTree> listAll = new ArrayList<>();
		listAll = blockedInfoRepository.maintOrgSelect(orgId);
		return listAll;
	}

    /**台站树查询
     *
     * @param orgId
     * @return
     */
    @Override
    public List<OrgTree> stationSelect(Long orgId) {
        //仅是组织表里的
        List<OrgTree> listAll = new ArrayList<>();
        listAll = blockedInfoRepository.maintOrgSelect(orgId);

        //站台表里的
        List<OrgTree> listStation = new ArrayList<>();
        listStation = blockedInfoRepository.stationSelect(orgId);

        listAll.addAll(listStation);

        return listAll;
    }

	/**管辖范围树
	 *
	 * @param orgId
	 * @return
	 */
	@Override
	public List<OrgTree> changeRangSelect(Long orgId) {
		//仅是组织表里的
		List<OrgTree> listAll = new ArrayList<>();
		listAll = blockedInfoRepository.changeRangSelect(orgId);

		return listAll;
	}

	/**
     *
     * 阻断状态判断
     */
	public static Long blockedState(Long orgId,Long transLevel){
		Long result = 0000000000L;
		if(LEVEL_Y.equals(orgId)){
            //待LV级审核
			result = 101011026001L;
		}
		if(LEVEL_L.equals(orgId)){
            //lv级别   先判断传输系统 非一级或KQ则流程结束 完成
			if(!ONE_LEVEL.equals(transLevel)&&!KQ_LEVEL.equals(transLevel)){
				result = 101011026003L;
			}else {
				result = 101011026002L;
			}
		}
		if(LEVEL_JD.equals(orgId)){
            //完成
			result = 101011026003L;
		}
		return result;
	}

    /**
     *
     * 阻断时长计算
     */
	public static Double blockedDate(BlockedInfo blockedInfo) {
		LocalDateTime startTime = blockedInfo.getStartDate().toLocalDateTime();
		LocalDateTime endTime = blockedInfo.getStopDate().toLocalDateTime();

		//保留2位小数
		DecimalFormat df = new DecimalFormat("0.00");
		Long num = ChronoUnit.MINUTES.between(startTime,endTime);

		Double blockedHours = Double.valueOf(df.format((float)num/60));
		return blockedHours;
	}

	/**阻断审批
	 *
	 * @param blockedId
	 * @return
	 */
	@Override
	public int approval(Long blockedId,Long approvalResult) {

		//获取当前登录信息
		//TODO 写死的登记人  查表
		Long userId = 444444444L;
		Long orgId = blockedInfoRepository.getOrgIdByuserId(userId);

		//获取当前的系统传输级别
		BlockedInfoDto blockedInfoDto = blockedInfoRepository.selectByBlockedId(blockedId);
		Long transLevel = Long.valueOf(blockedInfoDto.getTransLevel());
		Long blockedState = Long.valueOf(blockedInfoDto.getBlockedStateStr());

		BlockedInfo blockedInfo = new BlockedInfo();

		//Y级角色
		if(LEVEL_Y.equals(orgId)){
			//无需审批
		}

		//LV级角色  且  阻断状态为 待LV审批
		if(LEVEL_L.equals(orgId)&&BLOCK_STATUS_LV.equals(blockedState)){
			//添加审批人
			blockedInfo.setLvChecker(userId);
			//添加审批时间
			blockedInfo.setLvCheckDate(CommonUtil.convertStr2ZonedTime(CommonUtil.getTime(),"yyyy-MM-dd HH:mm:ss"));

			//审批通过
			if(PASS==approvalResult){
				//添加审批状态
				blockedInfo.setLvCheckState(PASS);

				//非一级或KQ
				if(!ONE_LEVEL.equals(transLevel)&&!KQ_LEVEL.equals(transLevel)) {
					//添加阻断状态
					blockedInfo.setBlockedState(BLOCK_STATUS_COM);
				}else {
					//一级或KQ		阻断状态变为待JD审核
					blockedInfo.setBlockedState(BLOCK_STATUS_JD);
				}
				BlockedInfoExample blockedInfoExample = new BlockedInfoExample();
				blockedInfoExample.createCriteria().andBlockedIdEqualTo(blockedId);
				blockedInfoRepository.updateByExampleSelective(blockedInfo,blockedInfoExample);
			}else {
				//审批不通过，逻辑删除
				blockedInfoRepository.blockedInfoDelete(blockedId);
			}
		}

		//JD级角色  且  阻断状态为 待JD审批
		if(LEVEL_JD.equals(orgId)&&BLOCK_STATUS_JD.equals(blockedState)){
			//添加审批人
			blockedInfo.setBaseChecker(userId);
			//添加审批时间
			blockedInfo.setBaseCheckDate(CommonUtil.convertStr2ZonedTime(CommonUtil.getTime(),"yyyy-MM-dd HH:mm:ss"));

			//审批通过
			if(PASS==approvalResult) {
				//添加审批状态
				blockedInfo.setBaseCheckState(PASS);
				//添加阻断状态
				blockedInfo.setBlockedState(BLOCK_STATUS_COM);

				BlockedInfoExample blockedInfoExample = new BlockedInfoExample();
				blockedInfoExample.createCriteria().andBlockedIdEqualTo(blockedId);
				blockedInfoRepository.updateByExampleSelective(blockedInfo,blockedInfoExample);
			}else {
				//审批不通过，逻辑删除
				blockedInfoRepository.blockedInfoDelete(blockedId);
			}
		}


		return 1;
	}


	/**阻断删除
	 * @param blockedId
	 * @return
	 */
	@Override
	public int blockedInfoDelete(Long blockedId) {
		return blockedInfoRepository.blockedInfoDelete(blockedId);
	}

	/**
	 * 阻断修改
	 * @param blockedInfo
	 * @return
	 */
	@Override
	public int blockedUpdate(BlockedInfo blockedInfo) {

		blockedInfo.setModifyDate(CommonUtil.convertStr2ZonedTime(CommonUtil.getTimeFen(),"yyyy-MM-dd HH:mm"));
		blockedInfo.setModifyUser(111111111L);

		BlockedInfoExample blockedInfoExample = new BlockedInfoExample();
		blockedInfoExample.createCriteria().andBlockedIdEqualTo(blockedInfo.getBlockedId());



		int result = blockedInfoRepository.updateByExampleSelective(blockedInfo,blockedInfoExample);

		if(!CommonUtil.checkIsNullOrEmpty(blockedInfo.getOptSegId())||!CommonUtil.checkIsNullOrEmpty(blockedInfo.getStationId())) {
            //业务影像范围修改  先删后增
            blockedSystemRepository.deleteByBlocked(blockedInfo.getBlockedId(), 1);
            affactRangeInsert(blockedInfo, 1);
        }
		return 1;
	}

	/**
	 * 申请赔款
	 * @param blockedId
	 * @return
	 */
	@Override
	public int claimStatusUpdate(Long blockedId) {
		return blockedInfoRepository.claimStatusUpdate(blockedId);
	}
}
