package com.zhou.business.dal.toolmall.entity;

import java.util.Date;

public class PurGoodsCategory {
    /**
     * null id
     */
    private String id;

    /**
     * null code
     */
    private String code;

    /**
     * null prefix
     */
    private Long prefix;

    /**
     * null name
     */
    private String name;

    /**
     * null level
     */
    private Integer level;

    /**
     * null type
     */
    private Integer type;

    /**
     * null parent_id
     */
    private String parentId;

    /**
     * null enabled
     */
    private boolean enabled;

    /**
     * null gmt_create
     */
    private Date gmtCreate;

    /**
     * null gmt_modify
     */
    private Date gmtModify;

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return id null
     */
    public String getId() {
        return id;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param id null
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return code null
     */
    public String getCode() {
        return code;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param code null
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return prefix null
     */
    public Long getPrefix() {
        return prefix;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param prefix null
     */
    public void setPrefix(Long prefix) {
        this.prefix = prefix;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return name null
     */
    public String getName() {
        return name;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param name null
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return level null
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param level null
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return type null
     */
    public Integer getType() {
        return type;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param type null
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return parent_id null
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param parentId null
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return enabled null
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param enabled null
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return gmt_create null
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param gmtCreate null
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return gmt_modify null
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param gmtModify null
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", prefix=").append(prefix);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", type=").append(type);
        sb.append(", parentId=").append(parentId);
        sb.append(", enabled=").append(enabled);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PurGoodsCategory other = (PurGoodsCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getPrefix() == null ? other.getPrefix() == null : this.getPrefix().equals(other.getPrefix()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.isEnabled() == other.isEnabled())
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()));
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getPrefix() == null) ? 0 : getPrefix().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + (isEnabled() ? 1231 : 1237);
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}