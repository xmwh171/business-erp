package com.zhou.business.dal.toolmall.entity;

import java.util.Date;

public class PurGoodsBrand {
    /**
     * null id
     */
    private Long id;

    /**
     * null brand_no
     */
    private String brandNo;

    /**
     * null brand_name
     */
    private String brandName;

    /**
     * null remark
     */
    private String remark;

    /**
     * null activate
     */
    private Integer activate;

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
    public Long getId() {
        return id;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param id null
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return brand_no null
     */
    public String getBrandNo() {
        return brandNo;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param brandNo null
     */
    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo == null ? null : brandNo.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return brand_name null
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param brandName null
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return remark null
     */
    public String getRemark() {
        return remark;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param remark null
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @return activate null
     */
    public Integer getActivate() {
        return activate;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 18:56:21
     * @param activate null
     */
    public void setActivate(Integer activate) {
        this.activate = activate;
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
        sb.append(", brandNo=").append(brandNo);
        sb.append(", brandName=").append(brandName);
        sb.append(", remark=").append(remark);
        sb.append(", activate=").append(activate);
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
        PurGoodsBrand other = (PurGoodsBrand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBrandNo() == null ? other.getBrandNo() == null : this.getBrandNo().equals(other.getBrandNo()))
            && (this.getBrandName() == null ? other.getBrandName() == null : this.getBrandName().equals(other.getBrandName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getActivate() == null ? other.getActivate() == null : this.getActivate().equals(other.getActivate()))
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
        result = prime * result + ((getBrandNo() == null) ? 0 : getBrandNo().hashCode());
        result = prime * result + ((getBrandName() == null) ? 0 : getBrandName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getActivate() == null) ? 0 : getActivate().hashCode());
        result = prime * result + (isEnabled() ? 1231 : 1237);
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        return result;
    }
}