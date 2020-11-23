package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("更新保障用户的所属友邻台站组织")
public class CustomerUpdateDto {
    @ApiModelProperty("保障用户ID")
    private Long puserId;
    @ApiModelProperty("友邻台站组织ID")
    private Long cusId;

    public Long getPuserId() {
        return puserId;
    }

    public void setPuserId(Long puserId) {
        this.puserId = puserId;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }
}
