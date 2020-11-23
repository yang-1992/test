package com.ctsi.block.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemDto implements Serializable {

    /** 系统类型*/
    private String systemType;

    /** 系统标识*/
    private String systemMark;

    /** 系统名称*/
    private String systemName;

    /** 系统层级*/
    private String systemDeptId;

    /** 系统代号*/
    private String systemAlias;

    /** 系统id*/
    private String systemId;

    /** 总数*/
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getSystemMark() {
        return systemMark;
    }

    public void setSystemMark(String systemMark) {
        this.systemMark = systemMark;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemDeptId() {
        return systemDeptId;
    }

    public void setSystemDeptId(String systemDeptId) {
        this.systemDeptId = systemDeptId;
    }

    public String getSystemAlias() {
        return systemAlias;
    }

    public void setSystemAlias(String systemAlias) {
        this.systemAlias = systemAlias;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
