package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("用户和台站关联关系传输对象")
public class UserStationRelDto {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("台站ID列表")
    private List<Long> stationIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getStationIds() {
        return stationIds;
    }

    public void setStationIds(List<Long> stationIds) {
        this.stationIds = stationIds;
    }
}
