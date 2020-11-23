package com.ctsi.space.service;


import com.ctsi.space.domain.BasUserStationRelation;
import com.ctsi.space.domain.BasUserStationRelationExample;
import com.ctsi.space.domain.dto.*;
import com.ctsi.ssdc.service.StrengthenBaseService;

import java.util.List;

/**
 * Service Interface for managing BasUserStationRelation.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface BasUserStationRelationService 
	extends StrengthenBaseService<BasUserStationRelation, Long, BasUserStationRelationExample>{

	/**
	 * 获取当前用户账户对应组织及组织对应的下级组织信息和台站信息组成的树，
	 * 同时设置对应用户的台站关联，不传userId时，则默认获取当前用户账户对应的树（用于用户新增），
	 * 反之则用于用户编辑
	 *
	 * @param userId 用户ID
	 * @author lechp
	 * @return 树结构StationOrgTreeNode
	 */
	StationOrgTreeNode getCurUserStationOrgTree(Long userId);

	/**
	 * 保存或新增对应的用户台站关联关系
	 *
	 * @param userStationRelUpdateDto dto
	 * @author lechp
	 * @return 结果
	 */
	ApiResult saveOrUpdateUserStationRel(UserStationRelUpdateDto userStationRelUpdateDto);

	/**
	 * 用户组织迁移
	 *
	 * @param userStationRelChangeOrgDto dto
	 * @author lechp
	 * @return 结果
	 */
	ApiResult userStationRelChangeOrg(UserStationRelChangeOrgDto userStationRelChangeOrgDto);

	/**
	 * 账户台站关联信息全量查询
	 *
	 * @author lechp
	 * @return 所有的用户台站关联关系
	 */
	List<UserStationRelDto> getAllUserStationRel();

	/**
	 * 资源某组织新增台站，对应设置该组织及以上组织的所有用户新增该台站关联关系（同步）
	 *
	 * @param userStationRelUpdateStationDto dto
	 * @author lechp
	 * @return 结果
	 */
	ApiResult userStationRelAddStation(UserStationRelUpdateStationDto userStationRelUpdateStationDto);


	/**
	 * 资源某组织删除台站，对应设置该组织及以上组织的所有用户删除该台站关联关系（同步）
	 *
	 * @param userStationRelUpdateStationDto dto
	 * @author lechp
	 * @return 结果
	 */
	ApiResult userStationRelDeleteStation(UserStationRelUpdateStationDto userStationRelUpdateStationDto);
}
