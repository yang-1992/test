package com.ctsi.vpn.service.impl;


import com.ctsi.vpn.domain.dto.ProtectUserDto;
import com.ctsi.vpn.domain.dto.VpnInfoDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Long;
import java.util.List;

import com.ctsi.vpn.domain.Vpn;
import com.ctsi.vpn.domain.VpnExample;
import com.ctsi.vpn.service.VpnService;
import com.ctsi.vpn.repository.VpnRepository;

import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;

/**
 * Service Implementation for managing Vpn.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class VpnServiceImpl 
	extends StrengthenBaseServiceImpl<VpnRepository, Vpn, Long, VpnExample> 
	implements VpnService {

	@Autowired
	VpnRepository vpnRepository;

	@Override
	public PageInfo<VpnInfoDto> getVpnData(Vpn vpn, int pageNum, int pageSize) {
		/*VpnExample vpnExample = new VpnExample();
		VpnExample.Criteria vpnCriteria = vpnExample.createCriteria();
		vpnCriteria.andCusNameEqualTo(vpn.getCusName());
		vpnCriteria.andNetCodeEqualTo(vpn.getNetCode());
		vpnCriteria.andVpnTypeEqualTo(vpn.getVpnType());
		vpnCriteria.andVpnTypeDetailEqualTo(vpn.getVpnTypeDetail());
		vpnCriteria.andRdEqualTo(vpn.getRd());
		List<Vpn> list = vpnRepository.selectByExample(vpnExample);*/

		PageHelper.startPage(pageNum,pageSize);
		List<VpnInfoDto> list = vpnRepository.getVpnData(vpn);


		PageInfo<VpnInfoDto> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	/**
	 * 模糊查用户
	 * @param userName
	 * @return
	 */
	@Override
	public List<ProtectUserDto> getUserInfo(String userName) {

		return vpnRepository.getUserInfo(userName);
	}
}
