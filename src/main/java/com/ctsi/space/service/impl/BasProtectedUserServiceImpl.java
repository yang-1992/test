package com.ctsi.space.service.impl;


import org.springframework.stereotype.Service;

import java.lang.Long;

import com.ctsi.space.domain.BasProtectedUser;
import com.ctsi.space.domain.BasProtectedUserExample;
import com.ctsi.space.service.BasProtectedUserService;
import com.ctsi.space.repository.BasProtectedUserRepository;

import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;

/**
 * Service Implementation for managing BasProtectedUser.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BasProtectedUserServiceImpl
		extends StrengthenBaseServiceImpl<BasProtectedUserRepository, BasProtectedUser, Long, BasProtectedUserExample>
		implements BasProtectedUserService {

}
