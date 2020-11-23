package com.ctsi.security.service.impl;


import com.ctsi.security.domain.BasOrganization;
import com.ctsi.security.domain.BasOrganizationExample;
import com.ctsi.security.domain.BasUser;
import com.ctsi.security.domain.BasUserExample;
import com.ctsi.security.domain.dto.UserOrgInfoDto;
import com.ctsi.security.repository.BasOrganizationRepository;
import com.ctsi.security.service.BasOrganizationService;
import com.ctsi.security.service.BasUserService;
import com.ctsi.space.consts.OrgConsts;
import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.domain.dto.SimpleOrgDto;
import com.ctsi.space.domain.dto.StationOrgTreeNode;
import com.ctsi.space.service.BasCustomerService;
import com.ctsi.space.utils.ApiResultUtil;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Service Implementation for managing BasOrganization.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BasOrganizationServiceImpl 
	extends StrengthenBaseServiceImpl<BasOrganizationRepository, BasOrganization, Long, BasOrganizationExample> 
	implements BasOrganizationService {

	@Resource
	private BasCustomerService basCustomerService;

	@Resource
	private BasUserService basUserService;

	@Override
	public UserOrgInfoDto getUserOrgInfo(Long userId) {
		return r.getUserOrgInfo(userId);
	}

	@Override
	public List<StationOrgTreeNode> findChildrenOrg(Long orgId) {
		return r.findChildrenOrg(orgId);
	}

	@Override
	public List<SimpleOrgDto> findChildrenOrgSimpleInfo(Long orgId) {
		return r.findChildrenOrgSimpleInfo(orgId);
	}

	@Override
	public String selectOrgPathByOrgId(Long orgId) {
		return r.selectOrgPathByOrgId(orgId);
	}

	@Override
	public ApiResult<List<SimpleOrgDto>> getOrgChild(Long orgId, Long orgType) {
		List<SimpleOrgDto> dtos;
		if (orgId == null && orgType == null) {
			dtos = new ArrayList<>();
			dtos.add(SimpleOrgDto.fromBasOrganization(
					findOne(OrgConsts.ZHAN_TYPE), OrgConsts.ZHAN_TYPE));
			dtos.add(SimpleOrgDto.fromBasOrganization(
					findOne(OrgConsts.YOU_TYPE), OrgConsts.YOU_TYPE));
			dtos.add(SimpleOrgDto.fromBasOrganization(
					findOne(OrgConsts.DI_TYPE), OrgConsts.DI_TYPE));
		} else {
			if (orgId == null) {
				return ApiResultUtil.createErrorApiResult("orgId不能为空");
			}
			if (orgType == null) {
				return ApiResultUtil.createErrorApiResult("orgType不能为空");
			}
			if (orgType == OrgConsts.ZHAN_TYPE ) {
				dtos = findChildrenOrgSimpleInfo(orgId);
			} else if (orgType == OrgConsts.YOU_TYPE) {
				dtos = basCustomerService.findChildrenOrgSimpleInfo(orgId);
			} else {
				return ApiResultUtil.createErrorApiResult("不支持的OrgType：" + orgType);
			}
		}

		return ApiResultUtil.createSuccessApiResult("OK", dtos);
	}

	@Override
	public List<SimpleOrgDto> searchByOrgFullName(String orgFullName) {
		return r.searchByOrgFullName(orgFullName);
	}

	@Override
	public BasOrganization findOneByUserId(Long userId) {
		BasUser basUser = basUserService.findOne(userId);
		if (basUser != null) {
			return findOne(basUser.getOrgId());
		}
		return null;
	}
}
