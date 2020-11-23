package com.ctsi.block.service.impl;


import com.ctsi.space.utils.PrimaryKeyBuild;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ctsi.block.domain.BlockedImg;
import com.ctsi.block.domain.BlockedImgExample;
import com.ctsi.block.service.BlockedImgService;
import com.ctsi.block.repository.BlockedImgRepository;

import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Service Implementation for managing BlockedImg.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BlockedImgServiceImpl 
	extends StrengthenBaseServiceImpl<BlockedImgRepository, BlockedImg, Object, BlockedImgExample> 
	implements BlockedImgService {

	private static final Logger logger = LoggerFactory.getLogger(BlockedImgService.class);

	@Autowired
	BlockedImgRepository blockedImgRepository;

	@Override
	public int savePicInfo(MultipartFile[] files, Long blockedId) {

		BlockedImg blockedImg = new BlockedImg();
		int result = 0;

		//阻断id
		blockedImg.setBlockedId(blockedId);

		//项目路径
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath);
		//图片的路径
		String picPath = file.getParent()+File.separator+"Image"+File.separator+blockedId;

		if(!new File(picPath).exists()){
			new File(picPath).mkdirs();
		}


		if(files!=null){
			for(int i=0;i<files.length;i++){
				//具体到每个图片路径
				String picName =blockedId+"_"+i+".jpg";
				String picSavePath = picPath + File.separator +picName;
				//图片落本地
				try {
					File picFile = new File(picSavePath);
					files[i].transferTo(picFile);
				}catch (IOException e){
					logger.warn("图片转化异常={}",e);
				}

				//图片落库
				//主键
				Long id = PrimaryKeyBuild.createId();
				blockedImg.setId(id);
				blockedImg.setImgName(picName);
				blockedImg.setImgPath(picSavePath);

				result = blockedImgRepository.insert(blockedImg);
				//循环中有一张失败，直接失败。
				if(result==0){
					return 0;
				}
			}
		}
		return result;
	}
}
