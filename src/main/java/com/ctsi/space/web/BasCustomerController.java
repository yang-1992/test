package com.ctsi.space.web;

import com.ctsi.security.consts.CookieConstant;
import com.ctsi.security.util.CookieUtil;
import com.ctsi.security.util.SecurityUtil;
import com.ctsi.space.domain.BasCustomer;
import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.domain.dto.CustomerDto;
import com.ctsi.space.domain.dto.CustomerStationDto;
import com.ctsi.space.domain.dto.CustomerUpdateDto;
import com.ctsi.space.service.BasCustomerService;
import com.ctsi.space.utils.ApiResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;


/**
 * 友邻单位相关接口
 *
 * @author lechp
 *
 */
@RestController
@RequestMapping("/api")
public class BasCustomerController {

    private final BasCustomerService basCustomerService;

    @Value("${space.station-page-url}")
    private String spaceStationPageUrl;

    public BasCustomerController(BasCustomerService basCustomerService) {
        this.basCustomerService = basCustomerService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }

    @GetMapping("/curUser/customer")
    @ApiOperation("查询当前用户的所属友邻台站组织")
    public ApiResult<CustomerStationDto> findCurUserCustomer() {
        return ApiResultUtil.createSuccessApiResult("OK",
                basCustomerService.findCustomerByUserId(SecurityUtil.getCurrentUserId()));
    }

    @PutMapping("/update/puser/customer")
    @ApiOperation("更新保障用户的所属友邻台站组织")
    public ApiResult<Integer> updateProtectedUserCustomer(@RequestBody CustomerUpdateDto customerUpdateDto) {
        int result = basCustomerService.updateCustomerByProtectedUserId(customerUpdateDto.getPuserId(), customerUpdateDto.getCusId());
        return result > 0 ? ApiResultUtil.createSuccessApiResult("更新成功", result) :
                ApiResultUtil.createErrorApiResult("更新失败", null);
    }

    @GetMapping("/user/customer")
    @ApiOperation("获取用户的所属友邻台站组织")
    public ApiResult<CustomerStationDto> getUserCustomer(@RequestParam Long userId) {
        return ApiResultUtil.createSuccessApiResult("OK", basCustomerService.findCustomerByUserId(userId));
    }

    @GetMapping("/puser/customer")
    @ApiOperation("获取保障用户的所属友邻台站组织")
    public ApiResult<CustomerStationDto> getpUserCustomer(@RequestParam Long puserId) {
        return ApiResultUtil.createSuccessApiResult("OK", basCustomerService.findCustomerByProtectedUserId(puserId));
    }

    @GetMapping("/child/customersStations")
    @ApiOperation("获取子友邻台站组织、台站列表")
    public ApiResult<List<CustomerStationDto>> getChildCustomersStations(@RequestParam Long cusId) {
        return ApiResultUtil.createSuccessApiResult("OK",
                basCustomerService.getChildrenCustomersAndStations(cusId));
    }

    @GetMapping("/child/customers")
    @ApiOperation("获取子友邻台站组织列表")
    public ApiResult<List<CustomerDto>> getChildCustomers(@RequestParam Long cusId) {
        return ApiResultUtil.createSuccessApiResult("OK",
                basCustomerService.getChildrenCustomers(cusId));
    }

    @GetMapping("/customer/{cusId}")
    @ApiOperation("获取友邻台站组织信息")
    public ApiResult<BasCustomer> getBasCustomer(@PathVariable Long cusId) {
        return ApiResultUtil.createSuccessApiResult("OK",
                basCustomerService.findOne(cusId));
    }

    /**
     * 重定向跳转前端台站页面
     */
    @GetMapping("/to/station/page/{tokenEncode}")
    public void toStationPage(HttpServletResponse response, @PathVariable("tokenEncode") String tokenEncode) throws IOException {

        String[] strs;
        try {
            strs = new String(Base64.getDecoder().decode(tokenEncode)).split("token-");
        } catch (IllegalArgumentException e) {
            return;
        }
        if (strs.length == 2) {
            String token = strs[1];
            CookieUtil.writeCookie(response, CookieConstant.TOKEN, token, true);
            response.sendRedirect(spaceStationPageUrl);
        }
    }
}
