package com.ctsi.block.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaohy
 * @version 1.0.1
 * @Description: 阻断查询
 * @date 2020-11-04 09:46:30
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockedParamDto implements java.io.Serializable{

    /** 专业*/
    private Long specilityType;
    /** 传输系统级别*/
    private Long transLevel;
    /** 阻断状态*/
    private Long blockedState;
    /** 阻断类型*/
    private Long blockedType;
    /** 阻断原因*/
    private String blockedReason;
    /** 维护单位类型*/
    private Long maintOrgType;
    /** 阻断开始时间*/
    private String startDate;
    /** 阻断结束时间*/
    private String stopDate;
    /** 当前账号角色*/
    private Long orgId;

    @Override
    public String toString() {
        return "BlockedParamDto{" +
                "specilityType=" + specilityType +
                ", transLevel=" + transLevel +
                ", blockedState=" + blockedState +
                ", blockedType=" + blockedType +
                ", blockedReason='" + blockedReason + '\'' +
                ", maintOrgType=" + maintOrgType +
                ", startDate='" + startDate + '\'' +
                ", stopDate='" + stopDate + '\'' +
                ", orgId=" + orgId +
                '}';
    }
}
