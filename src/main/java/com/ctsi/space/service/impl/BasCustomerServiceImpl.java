package com.ctsi.space.service.impl;


import com.ctsi.security.domain.BasUser;
import com.ctsi.security.service.BasUserService;
import com.ctsi.space.domain.BasCustomer;
import com.ctsi.space.domain.BasCustomerExample;
import com.ctsi.space.domain.dto.CustomerDto;
import com.ctsi.space.domain.dto.CustomerStationDto;
import com.ctsi.space.domain.dto.SimpleOrgDto;
import com.ctsi.space.repository.BasCustomerRepository;
import com.ctsi.space.repository.BasStationRepository;
import com.ctsi.space.service.BasCustomerService;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service Implementation for managing BasCustomer.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BasCustomerServiceImpl 
	extends StrengthenBaseServiceImpl<BasCustomerRepository, BasCustomer, Long, BasCustomerExample>
	implements BasCustomerService {

	@Resource
	private BasStationRepository basStationRepository;

	@Resource
	private BasUserService basUserService;

	@Override
	public CustomerStationDto findCustomerByUserId(Long userId) {
		return r.findCustomerByUserId(userId);
	}

	/**
	 * 根据保障用户ID查询其客户组织信息
	 *
	 * @param puserId 用户ID
	 *
	 * @return 客户组织信息
	 */
	@Override
	public CustomerStationDto findCustomerByProtectedUserId(Long puserId) {
		return r.findCustomerByProtectedUserId(puserId);
	}

	/**
	 * 更新保障用户的客户组织ID
	 * @param puserId 保障用户ID
	 * @param cusId 客户组织ID
	 * @return 更新行数
	 */
	@Override
	public int updateCustomerByProtectedUserId(Long puserId, Long cusId) {
		return r.updateCustomerByProtectedUserId(puserId, cusId);
	}

	@Override
	public List<CustomerStationDto> getChildrenCustomersAndStations(Long cusId) {
		List<CustomerStationDto> stations = basStationRepository.findStationsByCusId(cusId);
		List<CustomerStationDto> result = r.getChildrenCustomer(cusId);
		if (result == null) {
			return stations;
		}
		result.addAll(stations);
		return result;
	}

	/**
	 * 获取某客户组织下的组织
	 *
	 * @param cusId 客户组织ID
	 *
	 * @return 客户组织列表
	 */
	@Override
	public List<CustomerDto> getChildrenCustomers(Long cusId) {
		return r.getChildrenCustomer2(cusId);
	}

	/**
	 * 获取某客户组织下的组织的简要信息
	 *
	 * @param cusId 客户组织ID
	 *
	 * @return 组织的简要信息
	 */
	@Override
	public List<SimpleOrgDto> findChildrenOrgSimpleInfo(Long cusId) {
		return r.findChildrenOrgSimpleInfo(cusId);
	}

	@Override
	public BasCustomer findOneByUserId(Long userId) {
		BasUser basUser = basUserService.findOne(userId);
		if (basUser != null) {
			return findOne(basUser.getOrgId());
		}
		return null;
	}
}
