package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("组织新增台站传输对象")
public class UserStationRelUpdateStationDto {
    @ApiModelProperty("组织ID")
    private Long orgId;
    @ApiModelProperty("台站ID")
    private Long stationId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
}
