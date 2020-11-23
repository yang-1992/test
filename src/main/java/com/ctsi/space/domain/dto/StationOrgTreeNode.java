package com.ctsi.space.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("组织树结构（包括台站）")
public class StationOrgTreeNode {
    @ApiModelProperty("组织ID或台站ID")
    private Long id;
    @ApiModelProperty("组织名称或台站名称")
    private String name;
    @ApiModelProperty("父组织ID")
    private Long parentId;
    @ApiModelProperty("类型，1为组织，0为台站")
    private Integer type;
    @ApiModelProperty("组织级别")
    private Integer level;
    @ApiModelProperty("是否选择")
    private Boolean selected = true;
    @ApiModelProperty("子节点列表")
    private List<StationOrgTreeNode> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<StationOrgTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<StationOrgTreeNode> children) {
        this.children = children;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
