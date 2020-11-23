package com.ctsi.block.web;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.utils.ApiResultUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.ctsi.block.service.BlockedImgService;
import com.ctsi.block.domain.BlockedImg;
import com.ctsi.block.domain.BlockedImgExample;

import com.ctsi.ssdc.model.PageResult;
import com.ctsi.ssdc.util.HeaderUtil;
import org.springframework.web.multipart.MultipartFile;
import scala.Int;


/**
 * REST controller for managing BlockedImg.
 *
 * @author ctsi-biyi-generator
 *
 */
@RestController
@RequestMapping("/api")
public class BlockedImgController {

    private final Logger log = LoggerFactory.getLogger(BlockedImgController.class);

    private static final String ENTITY_NAME = "blockedImg";

    @Autowired
    BlockedImgService blockedImgService;

    public BlockedImgController(BlockedImgService blockedImgService) {
        this.blockedImgService = blockedImgService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
   
    @PostMapping("/blockedImgInsert")
    @ApiOperation("图片上传的方法")
    public ApiResult<Integer> savePicInfo(@RequestParam(value = "files")MultipartFile files[], @RequestParam Long blockedId ){
        int result = blockedImgService.savePicInfo(files,blockedId);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("图片上传成功",result):
                ApiResultUtil.createErrorApiResult("图片上传失败");
    }
    
}
