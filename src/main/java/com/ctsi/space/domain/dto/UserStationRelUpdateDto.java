package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("用户和台站关联关系更新传输对象")
public class UserStationRelUpdateDto {
    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("保存新增的台站ID的集合")
    private List<Long> stationIdsAdd;
    @ApiModelProperty("保存删除的台站ID的集合")
    private List<Long> stationIdsDelete;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getStationIdsAdd() {
        return stationIdsAdd;
    }

    public void setStationIdsAdd(List<Long> stationIdsAdd) {
        this.stationIdsAdd = stationIdsAdd;
    }

    public List<Long> getStationIdsDelete() {
        return stationIdsDelete;
    }

    public void setStationIdsDelete(List<Long> stationIdsDelete) {
        this.stationIdsDelete = stationIdsDelete;
    }
}
