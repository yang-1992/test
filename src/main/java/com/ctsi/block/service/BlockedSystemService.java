package com.ctsi.block.service;




import com.ctsi.block.domain.BlockedSystem;
import com.ctsi.block.domain.BlockedSystemExample;
import com.ctsi.block.domain.dto.SystemDto;
import com.ctsi.block.domain.dto.SystemResult;
import com.ctsi.ssdc.service.StrengthenBaseService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Service Interface for managing BlockedSystem.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface BlockedSystemService 
	extends StrengthenBaseService<BlockedSystem, Object, BlockedSystemExample>{

	/**
	 * 		传输系统的添加
	 * */
	int systemInsert(SystemResult systemResult);

	/**
	 * 传输系统的修改
	 * @param systemResult
	 * @param blockedId
	 * @return
	 */
	int systemUpdate(SystemResult systemResult,Long blockedId);

}
