package com.zhou.business.dal.toolmall.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BusSyncConfig {
    /**
     * null id
     */
    private Long id;

    /**
     * null code
     */
    private String code;

    /**
     * null name
     */
    private String name;

    /**
     * null properties
     */
    private String properties;

    /**
     * null gmt_next_sync
     */
    private Date gmtNextSync;

    /**
     * null gmt_create
     */
    private Date gmtCreate;

    /**
     * null gmt_modify
     */
    private Date gmtModify;

    /**
     * null enabled
     */
    private boolean enabled;

    /**
     * 解析参数
     * @param properties
     * @return
     */
    public static Map<String, String> parseProperties(String properties) {
        Map<String, String> map = new HashMap<String, String>();
        String[] pro = properties.replace("，",",").split(",");
        for (int i = 0; i < pro.length; i++) {
            String[] var = pro[i].split("=");
            map.put(var[0], var[1]);
        }
        return map;
    }


    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return id null
     */
    public Long getId() {
        return id;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param id null
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return code null
     */
    public String getCode() {
        return code;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param code null
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return name null
     */
    public String getName() {
        return name;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param name null
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return properties null
     */
    public String getProperties() {
        return properties;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param properties null
     */
    public void setProperties(String properties) {
        this.properties = properties == null ? null : properties.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return gmt_next_sync null
     */
    public Date getGmtNextSync() {
        return gmtNextSync;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param gmtNextSync null
     */
    public void setGmtNextSync(Date gmtNextSync) {
        this.gmtNextSync = gmtNextSync;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return gmt_create null
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param gmtCreate null
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return gmt_modify null
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param gmtModify null
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @return enabled null
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-04 13:11:26
     * @param enabled null
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
        sb.append(", name=").append(name);
        sb.append(", properties=").append(properties);
        sb.append(", gmtNextSync=").append(gmtNextSync);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append(", enabled=").append(enabled);
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
        BusSyncConfig other = (BusSyncConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProperties() == null ? other.getProperties() == null : this.getProperties().equals(other.getProperties()))
            && (this.getGmtNextSync() == null ? other.getGmtNextSync() == null : this.getGmtNextSync().equals(other.getGmtNextSync()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.isEnabled() == other.isEnabled());
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getProperties() == null) ? 0 : getProperties().hashCode());
        result = prime * result + ((getGmtNextSync() == null) ? 0 : getGmtNextSync().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + (isEnabled() ? 1231 : 1237);
        return result;
    }
}