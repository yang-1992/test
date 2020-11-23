package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("友邻台站组织")
public class CustomerDto {
    @ApiModelProperty("友邻台站组织ID")
    private Long cusId;
    @ApiModelProperty("友邻台站组织名称")
    private String cusName;
    @ApiModelProperty("友邻台站组织等级")
    private Integer cusLevel;

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

    public Integer getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(Integer cusLevel) {
        this.cusLevel = cusLevel;
    }
}
