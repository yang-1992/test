package com.ctsi.vpn.domain.dto;

import io.swagger.annotations.ApiModel;

@ApiModel("vpn信息")
public class VpnInfoDto {
    /** VPN id */
    private String vpnId;
    /** VPN网号*/
    private String netCode;
    /** VPN类型*/
    private String vpnType;
    /** VPN细类*/
    private String vpnTypeDetail;
    /** 用户名称*/
    private String cusName;
    /** 用户简称*/
    private String cusNameAb;
    /** 用户地址*/
    private String cusAddress;
    /** 用户联系人*/
    private String cusContact;
    /** 用户联系人电话*/
    private String cusTel;
    /** RD值*/
    private String rd;
    /** VRF名称*/
    private String vrf;
    /** VPN路由总数*/
    private String vpnRouteNum;
    /** 网路拓扑*/
    private String netTopo;
    /** VPN开通时间*/
    private String createTime;
    /** VPN修改时间*/
    private String updateTimestamp;

    public String getVpnId() {
        return vpnId;
    }

    public void setVpnId(String vpnId) {
        this.vpnId = vpnId;
    }

    public String getNetCode() {
        return netCode;
    }

    public void setNetCode(String netCode) {
        this.netCode = netCode;
    }

    public String getVpnType() {
        return vpnType;
    }

    public void setVpnType(String vpnType) {
        this.vpnType = vpnType;
    }

    public String getVpnTypeDetail() {
        return vpnTypeDetail;
    }

    public void setVpnTypeDetail(String vpnTypeDetail) {
        this.vpnTypeDetail = vpnTypeDetail;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusNameAb() {
        return cusNameAb;
    }

    public void setCusNameAb(String cusNameAb) {
        this.cusNameAb = cusNameAb;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusContact() {
        return cusContact;
    }

    public void setCusContact(String cusContact) {
        this.cusContact = cusContact;
    }

    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public String getVrf() {
        return vrf;
    }

    public void setVrf(String vrf) {
        this.vrf = vrf;
    }

    public String getVpnRouteNum() {
        return vpnRouteNum;
    }

    public void setVpnRouteNum(String vpnRouteNum) {
        this.vpnRouteNum = vpnRouteNum;
    }

    public String getNetTopo() {
        return netTopo;
    }

    public void setNetTopo(String netTopo) {
        this.netTopo = netTopo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public String toString() {
        return "VpnInfoDto{" +
                "vpnId='" + vpnId + '\'' +
                ", netCode='" + netCode + '\'' +
                ", vpnType='" + vpnType + '\'' +
                ", vpnTypeDetail='" + vpnTypeDetail + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusNameAb='" + cusNameAb + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusContact='" + cusContact + '\'' +
                ", cusTel='" + cusTel + '\'' +
                ", rd='" + rd + '\'' +
                ", vrf='" + vrf + '\'' +
                ", vpnRouteNum='" + vpnRouteNum + '\'' +
                ", netTopo='" + netTopo + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTimestamp='" + updateTimestamp + '\'' +
                '}';
    }
}
