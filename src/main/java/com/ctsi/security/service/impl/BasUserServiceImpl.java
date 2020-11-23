package com.ctsi.security.service.impl;


import com.ctsi.security.domain.BasUser;
import com.ctsi.security.domain.BasUserExample;
import com.ctsi.security.repository.BasUserRepository;
import com.ctsi.security.service.BasUserService;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing BasUser.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BasUserServiceImpl 
	extends StrengthenBaseServiceImpl<BasUserRepository, BasUser, Long, BasUserExample> 
	implements BasUserService {

	@Override
	public List<Long> selectUserIdsByOrgIds(List<Long> orgIds) {
		return r.selectUserIdsByOrgIds(orgIds);
	}
}
