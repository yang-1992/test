package com.ctsi.space.domain.dto;

import com.ctsi.security.domain.BasOrganization;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("组织信息（简）")
public class SimpleOrgDto {
    @ApiModelProperty("组织ID")
    private Long orgId;
    @ApiModelProperty("组织名称")
    private String orgName;
    @ApiModelProperty("组织全名")
    private String orgFullName;
    @ApiModelProperty("组织类型(1站支信通基地，2地方台站，11")
    private Long orgType;

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

    public Long getOrgType() {
        return orgType;
    }

    public void setOrgType(Long orgType) {
        this.orgType = orgType;
    }

    public static SimpleOrgDto fromBasOrganization(BasOrganization o, Long orgType) {
        SimpleOrgDto simpleOrgDto = new SimpleOrgDto();
        if (o != null) {
            simpleOrgDto.setOrgId(o.getOrgId());
            simpleOrgDto.setOrgName(o.getOrgName());
            simpleOrgDto.setOrgFullName(o.getOrgFullName());
            simpleOrgDto.setOrgType(orgType);
        }
        return simpleOrgDto;
    }
}
