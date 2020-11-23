package com.ctsi.vpn.domain.dto;

import io.swagger.annotations.ApiModel;

@ApiModel("保障用户")
public class ProtectUserDto {
    /** 用户id*/
    private String userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "ProtectUserDto{" +
                "userId='" + userId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusNameAb='" + cusNameAb + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusContact='" + cusContact + '\'' +
                ", cusTel='" + cusTel + '\'' +
                '}';
    }
}
