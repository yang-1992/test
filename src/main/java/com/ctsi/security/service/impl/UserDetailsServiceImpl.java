package com.ctsi.security.service.impl;

import com.ctsi.security.domain.BasOrganization;
import com.ctsi.security.domain.BasUser;
import com.ctsi.security.domain.BasUserExample;
import com.ctsi.security.domain.UserLoginDetail;
import com.ctsi.security.repository.BasOrganizationRepository;
import com.ctsi.security.repository.BasUserRepository;
import com.ctsi.ssdc.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BasUserRepository userRepository;

    @Autowired
    private BasOrganizationRepository basOrgRepository;
    
    /**
     * 是要你实现根据用户名查询用户信息，封装用户令牌的方法
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       BasUserExample userExample=new BasUserExample();
       BasUserExample.Criteria userCriteria=userExample.createCriteria();
       userCriteria.andUserLoginNameEqualTo(username);
//       userCriteria.andPasswordEqualTo(password);
       List<BasUser> userList=userRepository.selectByExample(userExample);
       if (CollectionUtils.isEmpty(userList)){
           throw new BizException("用户名或密码错误");
       }
       BasUser user=userList.stream()
               .findFirst()
               .orElse(null);
       //根据userId查询组织机构id
       BasOrganization basOrg = new BasOrganization();
       if(null != user && user.getOrgId()!=null ){
    	   
    	   basOrg = basOrgRepository.selectByPrimaryKey(user.getOrgId());
    	   
    	   if(null == basOrg && user.getUserId() == 1L){
    		   //超级管理员
    		   basOrg = new BasOrganization();
    		   basOrg.setOrgId(user.getOrgId());
    		   basOrg.setParentOrgId(user.getOrgId());
    		   basOrg.setOrgFullName("");
    	   }
       }       
       
       return convertUserAndOrganizationToUserDetail(user,basOrg);
    }

    private UserLoginDetail convertUserAndOrganizationToUserDetail(BasUser user, BasOrganization basOrg) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
    	UserLoginDetail userDetail = new UserLoginDetail();
    	userDetail.setCreateTime(user.getUpdateTime().format(df));
    	userDetail.setIsValid(user.getUserValid().intValue());
    	userDetail.setLoginId(user.getUserId());
    	userDetail.setLoginName(user.getUserLoginName());
    	userDetail.setPassword(user.getUserPassword());
    	userDetail.setTelephone(user.getUserTel());
    	userDetail.setUserName(user.getUserName());
    	if(null != basOrg && null != basOrg.getOrgId()){
    		userDetail.setOrgId(basOrg.getOrgId());
    	}
    	if(null != basOrg &&null !=basOrg.getOrgFullName()){
    		userDetail.setOrgFullName(basOrg.getOrgFullName());
    	}
    	
    	if(null != basOrg &&null != basOrg.getParentOrgId()){
    		userDetail.setOrgParentId(basOrg.getParentOrgId());
    	}
    	
        return userDetail;
    }
}
