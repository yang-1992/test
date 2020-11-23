package com.ctsi.security.service;


import com.ctsi.security.domain.BasUser;
import com.ctsi.security.domain.BasUserExample;
import com.ctsi.ssdc.service.StrengthenBaseService;

import java.util.List;

/**
 * Service Interface for managing BasUser.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface BasUserService 
	extends StrengthenBaseService<BasUser, Long, BasUserExample>{

	List<Long> selectUserIdsByOrgIds(List<Long> orgIds);
}
