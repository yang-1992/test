package com.ctsi.space.web;

import com.ctsi.space.domain.dto.*;
import com.ctsi.space.service.BasUserStationRelationService;
import com.ctsi.space.utils.ApiResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 账户台站关系相关接口
 *
 * @author lechp
 *
 */
@RestController
@RequestMapping("/api")
public class BasUserStationRelationController {

    private final BasUserStationRelationService basUserStationRelationService;

    public BasUserStationRelationController(BasUserStationRelationService basUserStationRelationService) {
        this.basUserStationRelationService = basUserStationRelationService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }

    @GetMapping("/userStationOrgTree")
    @ApiOperation(value = "获取当前用户账户对应组织及组织对应的下级组织信息和台站信息组成的树",
                    notes = "获取当前用户账户对应组织及组织对应的下级组织信息和台站信息组成的树，" +
                            "同时设置对应用户的台站关联，不传userId时，则默认获取当前用户账户对应的树（用于用户新增），" +
                            "反之则用于用户编辑")
    public ApiResult<StationOrgTreeNode> getUserStationOrgTree(@RequestParam(required = false) @ApiParam("用户ID") Long userId) {
        return ApiResultUtil.createSuccessApiResult("OK",
                basUserStationRelationService.getCurUserStationOrgTree(userId));
    }
 
    @PutMapping("/userStationRel")
    @ApiOperation(value = "保存或新增对应的用户台站关联关系",
                    notes = "传参：用户ID，一个保存新增的台站ID的集合，一个保存删除的台站ID的集合")
    public ApiResult saveOrUpdateUserStationRel(@RequestBody UserStationRelUpdateDto userStationRelUpdateDto) {
        return basUserStationRelationService.saveOrUpdateUserStationRel(userStationRelUpdateDto);
    }

    @PutMapping("/userStationRel/changeOrg")
    @ApiOperation(value = "用户组织迁移",
                    notes = "传参：用户ID，迁移目标的组织ID。会将用户之前的台站关联关系清空，然后默认添加上目标组织所有的台站关联")
    public ApiResult userStationRelChangeOrg(@RequestBody UserStationRelChangeOrgDto userStationRelChangeOrgDto) {
        return basUserStationRelationService.userStationRelChangeOrg(userStationRelChangeOrgDto);
    }

    @GetMapping("/sm/allUserStationRel")
    @ApiOperation("账户台站关联信息全量查询接口（同步）")
    public ApiResult<List<UserStationRelDto>> getAllUserStationRel() {
        return ApiResultUtil.createSuccessApiResult("OK",
                basUserStationRelationService.getAllUserStationRel());
    }

    @PutMapping("/userStationRel/addStation")
    @ApiOperation("资源某组织新增台站，对应设置该组织及以上组织的所有用户新增该台站关联关系（同步）")
    public ApiResult userStationRelAddStation(@RequestBody UserStationRelUpdateStationDto userStationRelUpdateStationDto) {
        return basUserStationRelationService.userStationRelAddStation(userStationRelUpdateStationDto);
    }

    @PutMapping("/userStationRel/deleteStation")
    @ApiOperation("资源某组织删除台站，对应设置该组织及以上组织的所有用户删除该台站关联关系（同步）")
    public ApiResult userStationRelDeleteStation(@RequestBody UserStationRelUpdateStationDto userStationRelUpdateStationDto) {
        return basUserStationRelationService.userStationRelDeleteStation(userStationRelUpdateStationDto);
    }
}
