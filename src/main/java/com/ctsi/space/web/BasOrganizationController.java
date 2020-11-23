package com.ctsi.space.web;

import com.ctsi.security.domain.BasOrganization;
import com.ctsi.security.domain.dto.UserOrgInfoDto;
import com.ctsi.security.service.BasOrganizationService;
import com.ctsi.security.util.SecurityUtil;
import com.ctsi.space.domain.BasCustomer;
import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.domain.dto.SimpleOrgDto;
import com.ctsi.space.service.BasCustomerService;
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

@RestController
@RequestMapping("/api")
public class BasOrganizationController {


    private final BasOrganizationService basOrganizationService;

    private final BasCustomerService basCustomerService;

    public BasOrganizationController(BasOrganizationService basOrganizationService, BasCustomerService basCustomerService) {
        this.basOrganizationService = basOrganizationService;
        this.basCustomerService = basCustomerService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @GetMapping("/curUserOrgInfo")
    @ApiOperation("获取当前用户的组织信息")
    public ApiResult<UserOrgInfoDto> getCurUserOrgInfo() {
        return ApiResultUtil.createSuccessApiResult("OK",
                basOrganizationService.getUserOrgInfo(SecurityUtil.getCurrentUserId()));
    }

    @GetMapping("/orgInfo")
    @ApiOperation("获取组织信息")
    public ApiResult<Object> getUserOrgInfo(@ApiParam("左侧树组织ID") @RequestParam(required = false) Long orgId,
                                                     @ApiParam("所编辑用户ID") @RequestParam(required = false) Long userId) {
        if (orgId == null && userId == null) {
            return ApiResultUtil.createErrorApiResult("左侧树组织ID和所编辑用户ID不能都为空");
        }
        if (orgId != null) {
            return ApiResultUtil.createSuccessApiResult("OK",
                    basOrganizationService.findOne(orgId));
        }
        BasOrganization basOrganization = basOrganizationService.findOneByUserId(userId);
        if (basOrganization == null) {
            BasCustomer basCustomer = basCustomerService.findOneByUserId(userId);
            return ApiResultUtil.createSuccessApiResult("OK", basCustomer);
        }
        return ApiResultUtil.createSuccessApiResult("OK", basOrganization);
    }

    @GetMapping("/orgChildSimpleInfo")
    @ApiOperation("获取子组织信息（简），不带参数获取第一级")
    public ApiResult<List<SimpleOrgDto>> getOrgChild(@ApiParam("组织ID") @RequestParam(required = false) Long orgId,
                                                     @ApiParam("组织类型") @RequestParam(required = false) Long orgType) {
        return basOrganizationService.getOrgChild(orgId, orgType);
    }

    @GetMapping("searchByFullName")
    @ApiOperation("用组织全名搜索")
    public ApiResult<List<SimpleOrgDto>> searchByFullName(@ApiParam("组织全名") String orgFullName) {
        return ApiResultUtil.createSuccessApiResult("OK", basOrganizationService.searchByOrgFullName(orgFullName));
    }
}
