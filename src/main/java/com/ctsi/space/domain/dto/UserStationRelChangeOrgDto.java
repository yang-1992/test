package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户组织迁移传输对象")
public class UserStationRelChangeOrgDto {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("目标组织ID")
    private Long orgId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
