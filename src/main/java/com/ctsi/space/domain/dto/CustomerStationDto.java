package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("友邻台站（组织、台站）")
public class CustomerStationDto {
    @ApiModelProperty("友邻台站组织ID")
    private Long cusId;
    @ApiModelProperty("友邻台站组织名称")
    private String cusName;
    @ApiModelProperty("台站ID")
    private Long stationId;
    @ApiModelProperty("台站名称")
    private String stationName;
    @ApiModelProperty("友邻台站组织等级")
    private Integer cusLevel;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("树ID")
    private String treeId;

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(Integer cusLevel) {
        this.cusLevel = cusLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }
}
