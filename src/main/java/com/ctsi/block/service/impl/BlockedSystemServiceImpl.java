package com.ctsi.block.service.impl;


import com.ctsi.block.domain.dto.SystemDto;
import com.ctsi.block.domain.dto.SystemResult;
import com.ctsi.block.utils.CommonUtil;
import com.ctsi.space.utils.PrimaryKeyBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ctsi.block.domain.BlockedSystem;
import com.ctsi.block.domain.BlockedSystemExample;
import com.ctsi.block.service.BlockedSystemService;
import com.ctsi.block.repository.BlockedSystemRepository;

import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;

import java.util.List;

/**
 * Service Implementation for managing BlockedSystem.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BlockedSystemServiceImpl 
	extends StrengthenBaseServiceImpl<BlockedSystemRepository, BlockedSystem, Object, BlockedSystemExample> 
	implements BlockedSystemService {

	@Autowired
	BlockedSystemRepository blockedSystemRepository;

    /**
     * 传输系统新增
     * @param systemResult
     * @return
     */
	@Override
	public int systemInsert(SystemResult systemResult ) {

		Long blockedId = systemResult.getBlockedId();
		List<SystemDto> list = systemResult.getList();
		int type = systemResult.getType();
		int result = 1;
		for(SystemDto systemDto : list){
			BlockedSystem blockedSystem= new BlockedSystem();
			blockedSystem.setDataResource(Long.valueOf(type));
			blockedSystem.setAffactId(PrimaryKeyBuild.createId());
			blockedSystem.setBlockedId(blockedId);
			blockedSystem.setSystemType(Long.valueOf(systemDto.getSystemType()));
			blockedSystem.setSystemId(Long.valueOf(systemDto.getSystemId()));
			blockedSystem.setSystemName(systemDto.getSystemName());
			blockedSystem.setSystemMark(systemDto.getSystemMark());

			Long systemDeptId = 0L;
			if(!CommonUtil.checkIsNullOrEmpty(systemDto.getSystemDeptId())){
				systemDeptId = Long.valueOf(systemDto.getSystemDeptId());
			}
			blockedSystem.setSystemLevel(systemDeptId);

			blockedSystem.setSystemAlias(systemDto.getSystemAlias());
			blockedSystem.setDataResource(Long.valueOf(type));

			result = blockedSystemRepository.insert(blockedSystem);
			if(result==0){
				return 0;
			}
		}

		return result;
	}


	/**
	 * 传输系统修改
	 * @param systemResult
	 * @param blockedId
	 * @return
	 */
	@Override
	public int systemUpdate(SystemResult systemResult, Long blockedId) {
	    int resource = 0;
		//先删除
		int delete = blockedSystemRepository.deleteByBlocked(blockedId,resource);

		//再添加
		systemResult.setBlockedId(blockedId);
		int insert = this.systemInsert(systemResult);
		return 1;
	}
}
