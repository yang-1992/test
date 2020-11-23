package com.ctsi.vpn.service;



import java.lang.Long;
import java.util.List;

import com.ctsi.vpn.domain.Vpn;
import com.ctsi.vpn.domain.VpnExample;
import com.ctsi.ssdc.service.StrengthenBaseService;
import com.ctsi.vpn.domain.dto.ProtectUserDto;
import com.ctsi.vpn.domain.dto.VpnInfoDto;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Service Interface for managing Vpn.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface VpnService 
	extends StrengthenBaseService<Vpn, Long, VpnExample>{

	/**
	 * 获取vpn数据
	 * @param vpn
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<VpnInfoDto> getVpnData(Vpn vpn, int pageNum, int pageSize);

	/**
	 * 模糊查用户
	 * @param userName
	 * @return
	 */
	List<ProtectUserDto> getUserInfo(String userName);

}
