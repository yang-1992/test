package com.ctsi.vpn.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.lang.Long;

import com.ctsi.space.domain.dto.ApiResult;
import com.ctsi.space.utils.ApiResultUtil;
import com.ctsi.vpn.domain.dto.ProtectUserDto;
import com.ctsi.vpn.domain.dto.VpnInfoDto;
import com.ctsi.vpn.util.CommonUtil;
import com.ctsi.vpn.util.PrimaryKeyBuild;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.ctsi.vpn.service.VpnService;
import com.ctsi.vpn.domain.Vpn;
import com.ctsi.vpn.domain.VpnExample;

import com.ctsi.ssdc.model.PageResult;
import com.ctsi.ssdc.util.HeaderUtil;
import com.ctsi.ssdc.util.ResponseUtil;


/**
 * REST controller for managing Vpn.
 *
 * @author ctsi-biyi-generator
 *
 */
@RestController
@RequestMapping("/api")
public class VpnController {

    private final Logger log = LoggerFactory.getLogger(VpnController.class);

    private static final String ENTITY_NAME = "vpn";

    //private final VpnService vpnService;
    @Autowired
    VpnService vpnService;

    public VpnController(VpnService vpnService) {
        this.vpnService = vpnService;
    }

    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
   
    /**
     * POST  /vpns : Create a new vpn.
     *
     * @param vpn the vpn to create
     * @return the ResponseEntity with status 201 (Created) and with body the new vpn, or with status 400 (Bad Request) if the vpn has already an vpnId
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/vpns")
    @ApiOperation("vpn数据新增")
    public ResponseEntity<Vpn> createVpn(@RequestBody Vpn vpn) throws URISyntaxException {
        log.debug("REST request to save Vpn : {}", vpn);
        vpn.setVpnId(PrimaryKeyBuild.createId());
        Vpn result = vpnService.insert(vpn);
        return ResponseEntity.created(new URI("/api/vpns" + "/" +result.getVpnId() ))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getVpnId().toString()))
            .body(result);
    }
	
    /**
     * PUT  /vpns : Updates an existing vpn.
     *
     * @param vpn the vpn to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated vpn,
     * or with status 400 (Bad Request) if the vpn is not valid,
     * or with status 500 (Internal Server Error) if the vpn couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/vpns")
    @ApiOperation("vpn数据修改")
    public ResponseEntity<Vpn> updateVpn(@RequestBody Vpn vpn)  {
        log.debug("REST request to update Vpn : {}", vpn);
        vpn.setUpdateTimestamp(CommonUtil.getZDTime());
        Vpn result = vpnService.update(vpn);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getVpnId().toString()))
            .body(result);
    }
    
    /**
     * GET  /vpns : get the vpns with page.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of vpns in body
     */
    @GetMapping("/vpnsByCriteria")
    public PageResult<Vpn> getVpnsByCriteria(VpnExample vpnExample, Pageable page) {
        log.debug("REST request to get VpnsByCriteria");
        return vpnService.findByExample(vpnExample, page);
    }
    
    /**
     * GET  /vpns : get the vpns.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of vpns in body
     */
    @GetMapping("/vpnsList")
    public PageResult<Vpn> getVpnsList(VpnExample vpnExample) {
        log.debug("REST request to get VpnsList");
        return vpnService.findByExample(vpnExample);
    }

    /**
     * GET  /vpns/:vpnId : get the "vpnId" vpn.
     *
     * @param vpnId the id of the vpn to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the vpn, or with status 404 (Not Found)
     */
    @GetMapping("/vpns/{vpnId}")
    public ResponseEntity<Vpn> getVpn(@PathVariable Long vpnId) {
        log.debug("REST request to get Vpn : {}", vpnId);
        Vpn vpn = vpnService.findOne(vpnId);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(vpn));
    }
	
    /**
     * DELETE  /vpns/:vpnId : delete the "vpnId" vpn.
     *
     * @param vpnId the id of the vpn to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/vpns/{vpnId}")
    public ResponseEntity<Void> deleteVpn(@PathVariable Long vpnId) {
        log.debug("REST request to delete Vpn : {}", vpnId);
        vpnService.delete(vpnId);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, vpnId.toString())).build();
    }

    /**
     * 获取vpn数据
     * @param vpn
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/getVpnData")
    @ApiOperation("/获取vpn数据")
    public PageInfo<VpnInfoDto> getVpnData(@RequestBody Vpn vpn, @RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize){
        log.debug("入参是vpn={}，pageNum={},pageSize={}",vpn.toString(),pageNum,pageSize);
        return vpnService.getVpnData(vpn,pageNum,pageSize);
    }

    /**
     * 模糊查用户
     * @param userName
     * @return
     */
    @PostMapping("/getUserInfo")
    @ApiOperation("模糊查用户")
    public ApiResult<List<ProtectUserDto>> getUserInfo(String userName){
        List list = vpnService.getUserInfo(userName);
        return ApiResultUtil.createSuccessApiResult("查询成功",list);
    }
    
}
