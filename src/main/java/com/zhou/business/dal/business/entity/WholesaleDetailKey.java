package com.zhou.business.dal.business.entity;

public class WholesaleDetailKey {
    /**
     * null wholesaleid
     */
    private String wholesaleid;

    /**
     * null proid
     */
    private String proid;

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return wholesaleid null
     */
    public String getWholesaleid() {
        return wholesaleid;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param wholesaleid null
     */
    public void setWholesaleid(String wholesaleid) {
        this.wholesaleid = wholesaleid == null ? null : wholesaleid.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return proid null
     */
    public String getProid() {
        return proid;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param proid null
     */
    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
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
        sb.append(", wholesaleid=").append(wholesaleid);
        sb.append(", proid=").append(proid);
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
        WholesaleDetailKey other = (WholesaleDetailKey) that;
        return (this.getWholesaleid() == null ? other.getWholesaleid() == null : this.getWholesaleid().equals(other.getWholesaleid()))
            && (this.getProid() == null ? other.getProid() == null : this.getProid().equals(other.getProid()));
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWholesaleid() == null) ? 0 : getWholesaleid().hashCode());
        result = prime * result + ((getProid() == null) ? 0 : getProid().hashCode());
        return result;
    }
}