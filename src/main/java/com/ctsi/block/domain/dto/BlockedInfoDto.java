package com.ctsi.block.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhaohy
 * @version 1.0.1
 * @Description: TODO
 * @date 2020-11-04 09:46:30
 * @Copyright 中国电信集团系统集成有限责任公司
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockedInfoDto implements java.io.Serializable{
    /** 阻断ID*/
    private Long blockedId;
    /** 专业 id*/
    private String specilityId;
    /** 专业*/
    private String specilityName;
    /** 传输系统*/
    private String systemName;
    /** 传输系统级别id*/
    private String transLevelId;
    /** 传输系统级别*/
    private String transLevel;
    /** 阻断开始时间*/
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    /** 阻断结束时间*/
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date stopDate;
    /** 阻断时长*/
    private Integer blockedDuration;
    /** 区域id*/
    private String areaId;
    /** 区域*/
    private String area;
    /** 维护单位类型id*/
    private String maintOrgTypeId;
    /** 维护单位类型*/
    private String maintOrgType;
    /** 维护单位 id*/
    private String maintOrgId;
    /** 维护单位*/
    private String maintOrg;
    /** 所属JUDUI管辖范围id*/
    private String chargeRangeId;
    /** 所属JUDUI管辖范围*/
    private String chargeRange;
    /**阻断类型id*/
    private String blockedTypeId;
    /**阻断类型*/
    private String blockedType;
    /**阻断原因id*/
    private String blockedReasonId;
    /**阻断原因*/
    private String blockedReason;
    /**阻断光缆id*/
    private String optId;
    /**阻断光缆*/
    private String optName;
    /**阻断光缆段id*/
    private String optSegId;
    /**阻断光缆段*/
    private String optSegName;
    /**阻断TZ id*/
    private String stationId;
    /**阻断TZ*/
    private String stationName;
    /**是否统计该blocked次数id*/
    //private Long isCntTimesId;
    /**是否统计该blocked次数*/
    private Long isCntTimes;
    /**是否统计该blocked时长id*/
    //private Long isCntDurationId;
    /**是否统计该blocked时长*/
    private Long isCntDuration;
    /** 阻断状态*/
    private Long blockedState;
    /** 阻断状态*/
    private String blockedStateStr;
    /** 索赔状态*/
    private String claimState;
    /** 登记人*/
    private String userName;
    /** 登记时间*/
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
    private Date commitDate;
    /** LV级审核人*/
    private String lvChecker;
    /** LV级审核时间*/
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date lvCheckDate;
    /** JD级审核人*/
    private String baseChecker;
    /** JD级审核时间*/
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date baseCheckDate;
    /** 编辑权限*/
    private Integer editRight = 0 ;
    /** 删除权限*/
    private Integer deleteRight = 0;
    /** 审批权限*/
    private Integer approvalRight = 0 ;
    /** 申请索赔权限*/
    private Integer claimRight = 0;

    /** 管辖范围*/

}
