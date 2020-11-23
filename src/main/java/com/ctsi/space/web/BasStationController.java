package com.ctsi.space.web;

import com.ctsi.security.domain.UserLoginDetail;
import com.ctsi.security.util.SecurityUtil;
import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.domain.dto.CustomerDto;
import com.ctsi.space.domain.dto.CustomerStationDto;
import com.ctsi.space.domain.dto.SimpleStationDto;
import com.ctsi.space.service.BasCustomerService;
import com.ctsi.space.service.BasStationService;
import com.ctsi.space.utils.ApiResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BasStationController {

    private BasStationService basStationService;

    private BasCustomerService basCustomerService;

    public BasStationController(BasStationService basStationService, BasCustomerService basCustomerService) {
        this.basStationService = basStationService;
        this.basCustomerService = basCustomerService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/searchStationCurUser")
    @ApiOperation("搜索当前用户组织下的台站")
    public ApiResult<List<SimpleStationDto>> searchStationCurUser(@ApiParam("台站名称") String stationName) {
        UserLoginDetail userLoginDetail = SecurityUtil.getCurrentUser().orElse(null);
        if (userLoginDetail == null) {
            return ApiResultUtil.createErrorApiResult("未登录");
        }
        CustomerStationDto customerStationDto = basCustomerService.findCustomerByUserId(SecurityUtil.getCurrentUserId());
        if (customerStationDto == null || customerStationDto.getCusId() == null) {
            return ApiResultUtil.createErrorApiResult("未绑定保障用户");
        }
        return ApiResultUtil.createSuccessApiResult("OK",
                basStationService.searchStationByNameAndOrgId(stationName, customerStationDto.getCusId()));
    }
}
