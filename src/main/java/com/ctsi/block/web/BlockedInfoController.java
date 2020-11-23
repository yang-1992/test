package com.ctsi.block.web;

import com.ctsi.block.domain.BlockedInfo;
import com.ctsi.block.domain.dto.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctsi.block.utils.CommonUtil;
import com.ctsi.block.utils.HttpUtil;
import com.ctsi.block.domain.dto.BlockedInfoDto;
import com.ctsi.block.domain.dto.BlockedParamDto;
import com.ctsi.block.domain.dto.OrgTree;
import com.ctsi.block.domain.dto.SystemDto;
import com.ctsi.block.service.BlockedInfoService;
import com.ctsi.block.utils.HttpUtil;
import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.utils.ApiResultUtil;
import com.ctsi.space.utils.PrimaryKeyBuild;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultDefaultValueProcessor;
import org.neo4j.cypher.internal.compiler.v2_1.functions.Str;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * REST controller for managing BlockedInfo.
 *
 * @author ctsi-biyi-generator
 *
 */
@RestController
@RequestMapping("/api")
public class BlockedInfoController {

    private final Logger log = LoggerFactory.getLogger(BlockedInfoController.class);

    private static final String ENTITY_NAME = "blockedInfo";

    private final BlockedInfoService blockedInfoService;

    public BlockedInfoController(BlockedInfoService blockedInfoService) {
        this.blockedInfoService = blockedInfoService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }

    /**阻断增加页面初始化
     *
     * @return
     */
    @PostMapping("/initInsertPage")
    @ApiOperation("阻断增加页面初始化接口，用来获得阻断id")
    public ApiResult<Long> initInsertPage(){
        Long id = PrimaryKeyBuild.createId();
        return ApiResultUtil.createSuccessApiResult("ok",id);
    }

    /**阻断增加
     *
     * @param blockedInfo
     * @return
     */
    @PostMapping("/blockedInfoInsert")
    @ApiOperation("阻断增加功能")
	public ApiResult<Integer> blockedInfoInsert(@RequestBody BlockedInfo blockedInfo){
        log.debug("传入的参数为={}",blockedInfo.toString());
        int result = blockedInfoService.blockedInfoInsert(blockedInfo);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("增加成功",result):
                ApiResultUtil.createErrorApiResult("增加失败");
    }

    /**
     * 阻断查询
     * @param paramDto
     * @return
     */
    @PostMapping("/blockInfoSelect")
    @ApiOperation("阻断查询方法")
    public PageInfo<BlockedInfoDto> blockedInfoSelect(@RequestBody BlockedParamDto paramDto,@RequestParam("pageSize") int pageSize,@RequestParam("pageNum")int pageNum){
        PageInfo page = new PageInfo();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);

        PageInfo<BlockedInfoDto> pageInfo = blockedInfoService.blockedInfoSelect(paramDto, page);
        return pageInfo;
    }

    /**台站树
     *
     * @param orgId
     * @return
     */
    @GetMapping("/stationSelect")
    @ApiOperation("台站树")
    public ApiResult<List<OrgTree>> stationSelect(@RequestParam("orgId") Long orgId){
        List<OrgTree> list = blockedInfoService.stationSelect(orgId);
        return ApiResultUtil.createSuccessApiResult("查询成功",list);
    }

    /**维护单位树
     *
     * @param orgId
     * @return
     */
    @GetMapping("/maintOrgSelect")
    @ApiOperation("维护单位树")
    public ApiResult<List<OrgTree>> maintOrgSelect(@RequestParam("orgId") Long orgId){
        List<OrgTree> list = blockedInfoService.maintOrgSelect(orgId);
        return ApiResultUtil.createSuccessApiResult("查询成功",list);
    }

    /**管辖范围树
     *
     * @param orgId
     * @return
     */
    @GetMapping("/changeRangSelect")
    @ApiOperation("管辖范围树")
    public ApiResult<List<OrgTree>> changeRangSelect(@RequestParam("orgId") Long orgId){
        List<OrgTree> list = blockedInfoService.changeRangSelect(orgId);
        return ApiResultUtil.createSuccessApiResult("查询成功",list);
    }

    /**传输系统查询
     *
     * @param systemLevel
     * @param systemCode
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @PostMapping("/systemSelectFromSyBase")
    @ApiOperation("传输系统查询")
    public JSONObject systemSelectFromSyBase(@RequestParam("systemLevel") Long systemLevel, @RequestParam("systemCode") String systemCode,@RequestParam("pageSize")int pageSize,@RequestParam("pageNumber")int pageNumber){
        //url拼接
        String url = "http://192.168.203.150:9000/api/systemSelect?";
        String param ="systemLevel="+systemLevel+"&systemCode="+systemCode+"&pageSize="+pageSize+"&pageNumber="+pageNumber;

        //http请求调用
        String result = HttpUtil.sendPost(url,param);
        result = result.replace("null","\"\"");

        if(!CommonUtil.checkIsNullOrEmpty(result)) {
            /*Map<Object,Object> map = JSONObject.fromObject(result);
            List<SystemDto> list = (List<SystemDto>) map.get("data");
            return ApiResultUtil.createSuccessApiResult("查询成功", list);*/

            return JSONObject.fromObject(result);
        }else {
            return null;
        }
    }

    /**阻断光缆查询
     *
     * @param blockName
     * @return
     */
    @PostMapping("/blockOptSelectFromSyBase")
    @ApiOperation("阻断光缆查询")
    public ApiResult<List<TrunkOpt>> blockOptSelectFromSyBase(@RequestParam("blockName")String blockName){
        //url拼接
        String url = "http://192.168.203.150:9000/api/blockOptSelect?";

        //http请求调用
        String param ="blockName="+blockName;
        String result = HttpUtil.sendPost(url,param);

        if(!CommonUtil.checkIsNullOrEmpty(result)) {
            Map<Object,Object> map = JSONObject.fromObject(result);
            List<TrunkOpt> list = (List<TrunkOpt>) map.get("data");
            return ApiResultUtil.createSuccessApiResult("查询成功", list);
        }else {
            return ApiResultUtil.createErrorApiResult("查询失败");
        }
    }

    /**
     * 阻断光缆段查询
     * @param blockedOptId
     * @return
     */
    @PostMapping("/blockOptSegmentSelectFromSyBase")
    @ApiOperation("阻断光缆段查询")
    public ApiResult<List<TrunkOptSegment>> blockOptSegmentSelectFromSyBase(@RequestParam("blockedOptId")Long blockedOptId){
        //url拼接
        String url = "http://192.168.203.150:9000/api/blockOptSegmentSelect?";
        //http请求调用
        String param ="blockedOptId="+blockedOptId;
        String result = HttpUtil.sendPost(url,param);

        if(!CommonUtil.checkIsNullOrEmpty(result)) {
            Map<Object,Object> map = JSONObject.fromObject(result);
            List<TrunkOptSegment> list = (List<TrunkOptSegment>) map.get("data");
            return ApiResultUtil.createSuccessApiResult("查询成功", list);
        }else {
            return ApiResultUtil.createErrorApiResult("查询失败");
        }
    }



    /**阻断审批
     *
     * @param blockedId
     * @param approvalResult    0通过  1不通过
     * @return
     */
    @PostMapping("/approval")
    @ApiOperation("阻断审批")
    public ApiResult<Integer> approval(@RequestParam("blockedId") Long blockedId,@RequestParam("approvalResult")Long approvalResult){

        int result = blockedInfoService.approval(blockedId,approvalResult);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("审批成功",result):
                ApiResultUtil.createErrorApiResult("审批失败");
    }

    /**审批删除
     *
     * @param blockedId
     * @return
     */
    @DeleteMapping("blockedInfoDelete")
    @ApiOperation("阻断删除")
    public ApiResult<Integer> blockedInfoDelete(@RequestParam("blockedId")Long blockedId){
        int result = blockedInfoService.blockedInfoDelete(blockedId);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("删除成功",result):
                ApiResultUtil.createErrorApiResult("删除失败");
    }

    /**
     * 业务影响范围查询
     * @param id
     * @param type       0 光缆段id    1 台站id、
     * @return
     */
    @PostMapping("/blockedSystemSelectSyBase")
    @ApiOperation("业务影响范围查询")
    public JSONObject blockedSystemSelectByBase(@RequestParam("id") Long id,@RequestParam("type")int type,@RequestParam("systemLevel") Long systemLevel, @RequestParam("systemCode") String systemCode,@RequestParam("pageSize")int pageSize,@RequestParam("pageNumber")int pageNumber){
        //url拼接
        String url = "http://192.168.203.150:9000/api/blockedSystemSelect?";
        //http请求调用
        String param ="id="+id+"&type="+type+"&systemLevel="+systemLevel+"&systemCode="+systemCode+"&pageSize="+pageSize+"&pageNumber="+pageNumber;
        String result = HttpUtil.sendPost(url,param);
        result = result.replace("null","\"\"");

        if(!CommonUtil.checkIsNullOrEmpty(result)) {
            /*Map<Object,Object> map = JSONObject.fromObject(result);
            List<SystemDto> list = (List<SystemDto>) map.get("data");
            return ApiResultUtil.createSuccessApiResult("查询成功", list);*/

            return JSONObject.fromObject(result);
        }else {
            return null;
        }
    }

    /**
     *      阻断修改
     * @param blockedInfo
     * @return
     */
    @PostMapping("/blockedInfoUpdate")
    @ApiOperation("阻断修改")
    public ApiResult<Integer> blockedInfoUpdate(@RequestBody BlockedInfo blockedInfo){
        log.debug("入参是={}",blockedInfo.toString());
        int result = blockedInfoService.blockedUpdate(blockedInfo);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("修改成功",result):
                ApiResultUtil.createErrorApiResult("修改失败");
    }

    /**
     * 申请索赔
     * @param blockedId
     * @return
     */
    @PostMapping("/claimStatusUpdate")
    @ApiOperation("申请索赔")
    public ApiResult<Integer> claimStatusUpdate(Long blockedId){
        int result = blockedInfoService.claimStatusUpdate(blockedId);
        return result > 0 ? ApiResultUtil.createSuccessApiResult("申请索赔成功",result):
                ApiResultUtil.createErrorApiResult("申请索赔失败");
    }

}
