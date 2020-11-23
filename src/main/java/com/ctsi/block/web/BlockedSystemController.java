package com.ctsi.block.web;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ctsi.block.domain.dto.SystemDto;
import com.ctsi.block.domain.dto.SystemResult;
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

import com.ctsi.block.service.BlockedSystemService;
import com.ctsi.block.domain.BlockedSystem;
import com.ctsi.block.domain.BlockedSystemExample;

import com.ctsi.ssdc.model.PageResult;
import com.ctsi.ssdc.util.HeaderUtil;


/**
 * REST controller for managing BlockedSystem.
 *
 * @author ctsi-biyi-generator
 *
 */
@RestController
@RequestMapping("/api")
public class BlockedSystemController {

    private final Logger log = LoggerFactory.getLogger(BlockedSystemController.class);

    private static final String ENTITY_NAME = "blockedSystem";

    @Autowired
    BlockedSystemService blockedSystemService;

    public BlockedSystemController(BlockedSystemService blockedSystemService) {
        this.blockedSystemService = blockedSystemService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
   
    /**
     *      传输系统的添加
     *
     *
     * */
    @PostMapping("/systemInsert")
    @ApiOperation("传输系统添加")
    public ApiResult<Integer> systemInsert(@RequestBody SystemResult systemResult){
        int result = blockedSystemService.systemInsert(systemResult);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("增加成功",result):
                ApiResultUtil.createErrorApiResult("增加失败");
    }

    /**
     * 传输系统修改
     * @param systemResult
     * @param blockedId
     * @return
     */
    @PostMapping("/systemUpdate")
    @ApiOperation("传输系统修改")
    public ApiResult<Integer> systemUpdate(@RequestBody SystemResult systemResult,@RequestParam("blockedId")Long blockedId){
       //因为从外部调用获得，不是修改，理解为先删除，再新增
        int result = blockedSystemService.systemUpdate(systemResult,blockedId);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("修改成功",result):
                ApiResultUtil.createErrorApiResult("修改失败");

    }


}
