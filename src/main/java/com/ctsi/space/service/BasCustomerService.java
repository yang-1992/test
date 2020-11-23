package com.ctsi.space.service;


import com.ctsi.security.domain.BasOrganization;
import com.ctsi.space.domain.BasCustomer;
import com.ctsi.space.domain.BasCustomerExample;
import com.ctsi.space.domain.dto.CustomerDto;
import com.ctsi.space.domain.dto.CustomerStationDto;
import com.ctsi.space.domain.dto.SimpleOrgDto;
import com.ctsi.ssdc.service.StrengthenBaseService;

import java.util.List;

/**
 * Service Interface for managing BasCustomer.
 *
 * @author ctsi-biyi-generator
 */
public interface BasCustomerService
        extends StrengthenBaseService<BasCustomer, Long, BasCustomerExample> {

    /**
     * 根据用户ID查询其客户组织信息
     * @param userId 用户ID
     * @return 客户组织信息
     */
    CustomerStationDto findCustomerByUserId(Long userId);

    /**
     * 根据保障用户ID查询其客户组织信息
     * @param puserId 用户ID
     * @return 客户组织信息
     */
    CustomerStationDto findCustomerByProtectedUserId(Long puserId);

    /**
     * 更新保障用户的客户组织ID
     * @param puserId 保障用户ID
     * @param cusId 客户组织ID
     * @return 更新行数
     */
    int updateCustomerByProtectedUserId(Long puserId, Long cusId);

    /**
     * 获取某客户组织下的组织、台站
     * @param cusId 客户组织ID
     * @return 客户组织台站列表
     */
    List<CustomerStationDto> getChildrenCustomersAndStations(Long cusId);

    /**
     * 获取某客户组织下的组织
     * @param cusId 客户组织ID
     * @return 客户组织列表
     */
    List<CustomerDto> getChildrenCustomers(Long cusId);

    /**
     * 获取某客户组织下的组织的简要信息
     * @param cusId 客户组织ID
     * @return 组织的简要信息
     */
    List<SimpleOrgDto> findChildrenOrgSimpleInfo(Long cusId);

    BasCustomer findOneByUserId(Long userId);
}
