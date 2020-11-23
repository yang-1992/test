package com.ctsi.security.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户组织信息传输对象")
public class UserOrgInfoDto {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("用户名称")
    private String userName;
    @ApiModelProperty("组织ID")
    private Long orgId;
    @ApiModelProperty("组织名称")
    private String orgName;
    @ApiModelProperty("组织全名称")
    private String orgFullName;
    @ApiModelProperty("组织等级")
    private Integer orgLevel;
    @ApiModelProperty("父组织ID")
    private Long parentOrgId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgFullName() {
        return orgFullName;
    }

    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }
}
