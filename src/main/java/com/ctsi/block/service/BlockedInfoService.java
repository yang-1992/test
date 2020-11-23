package com.ctsi.block.service;


import com.ctsi.block.domain.BlockedInfo;
import com.ctsi.block.domain.BlockedInfoExample;
import com.ctsi.block.domain.dto.BlockedInfoDto;
import com.ctsi.block.domain.dto.BlockedParamDto;
import com.ctsi.block.domain.dto.OrgTree;
import com.ctsi.ssdc.service.StrengthenBaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Service Interface for managing BlockedInfo.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface BlockedInfoService 
	extends StrengthenBaseService<BlockedInfo, Object, BlockedInfoExample>{

	/**阻断增加
	 *
	 * @param blockedInfo
	 * @return
	 */
	int blockedInfoInsert(BlockedInfo blockedInfo);

	/**
	 * 阻断查询
	 * @param dto
	 * @param page
	 * @return
	 */
	PageInfo<BlockedInfoDto> blockedInfoSelect(BlockedParamDto dto, PageInfo page);

	/**\
	 * 		组织机构树
	 *
	 * */
	List<OrgTree> maintOrgSelect(Long orgId);

	/**
	 * 台站树
	 * @param orgId
	 * @return
	 */
	List<OrgTree> stationSelect(Long orgId);

	/**
	 * 管辖范围树
	 * @param orgId
	 * @return
	 */
	List<OrgTree> changeRangSelect(Long orgId);




	/**阻断审批
	 *
	 * @param blockedId
	 * @param approvalResult
	 * @return
	 */
	int approval(Long blockedId,Long approvalResult);

	/**阻断删除
	 *
	 * @param blockedId
	 * @return
	 */
	int blockedInfoDelete(Long blockedId);

	/**
	 * 阻断修改
	 * @param blockedInfo
	 * @return
	 */
	int blockedUpdate(BlockedInfo blockedInfo);

	/**
	 * 申请索赔
	 * @param blockedId
	 * @return
	 */
	int claimStatusUpdate(Long blockedId);
}
