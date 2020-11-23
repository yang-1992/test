package com.ctsi.security.service;


import com.ctsi.security.domain.BasOrganization;
import com.ctsi.security.domain.BasOrganizationExample;
import com.ctsi.security.domain.dto.UserOrgInfoDto;
import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.domain.dto.SimpleOrgDto;
import com.ctsi.space.domain.dto.StationOrgTreeNode;
import com.ctsi.ssdc.service.StrengthenBaseService;

import java.util.List;

/**
 * Service Interface for managing BasOrganization.
 *
 * @author ctsi-biyi-generator
 */
public interface BasOrganizationService
        extends StrengthenBaseService<BasOrganization, Long, BasOrganizationExample> {

    UserOrgInfoDto getUserOrgInfo(Long userId);

    List<StationOrgTreeNode> findChildrenOrg(Long orgId);

    List<SimpleOrgDto> findChildrenOrgSimpleInfo(Long orgId);

    String selectOrgPathByOrgId(Long orgId);

    ApiResult<List<SimpleOrgDto>> getOrgChild(Long orgId, Long orgType);

    List<SimpleOrgDto> searchByOrgFullName(String orgFullName);

    BasOrganization findOneByUserId(Long userId);
}
