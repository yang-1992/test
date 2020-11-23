package com.ctsi.block.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

public class SystemResult implements Serializable {
    private Long blockedId;
    private List<SystemDto> list;
    private int type;

    public Long getBlockedId() {
        return blockedId;
    }

    public void setBlockedId(Long blockedId) {
        this.blockedId = blockedId;
    }

    public List<SystemDto> getList() {
        return list;
    }

    public void setList(List<SystemDto> list) {
        this.list = list;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SystemResult{" +
                "blockedId=" + blockedId +
                ", list=" + list +
                ", type=" + type +
                '}';
    }
}
