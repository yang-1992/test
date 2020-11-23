package com.ctsi.block.service;




import com.ctsi.block.domain.BlockedImg;
import com.ctsi.block.domain.BlockedImgExample;
import com.ctsi.ssdc.service.StrengthenBaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Service Interface for managing BlockedImg.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface BlockedImgService 
	extends StrengthenBaseService<BlockedImg, Object, BlockedImgExample>{

	//保存图片
	int savePicInfo(MultipartFile files[], Long blockedId);

}
