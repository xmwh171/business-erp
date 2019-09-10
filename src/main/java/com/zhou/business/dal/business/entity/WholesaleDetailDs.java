package com.zhou.business.dal.business.entity;

import java.math.BigDecimal;

public class WholesaleDetailDs extends WholesaleDetailKey {
    /**
     * null seatid
     */
    private String seatid;

    /**
     * null saleqty
     */
    private BigDecimal saleqty;

    /**
     * null saleprice
     */
    private BigDecimal saleprice;

    /**
     * null saletax
     */
    private BigDecimal saletax;

    /**
     * null costprice
     */
    private BigDecimal costprice;

    /**
     * null packetqty
     */
    private BigDecimal packetqty;

    /**
     * null boxqty
     */
    private BigDecimal boxqty;

    /**
     * null flowid
     */
    private Integer flowid;

    /**
     * null frprice
     */
    private BigDecimal frprice;

    /**
     * null exrate
     */
    private BigDecimal exrate;

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return seatid null
     */
    public String getSeatid() {
        return seatid;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param seatid null
     */
    public void setSeatid(String seatid) {
        this.seatid = seatid == null ? null : seatid.trim();
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return saleqty null
     */
    public BigDecimal getSaleqty() {
        return saleqty;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param saleqty null
     */
    public void setSaleqty(BigDecimal saleqty) {
        this.saleqty = saleqty;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return saleprice null
     */
    public BigDecimal getSaleprice() {
        return saleprice;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param saleprice null
     */
    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return saletax null
     */
    public BigDecimal getSaletax() {
        return saletax;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param saletax null
     */
    public void setSaletax(BigDecimal saletax) {
        this.saletax = saletax;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return costprice null
     */
    public BigDecimal getCostprice() {
        return costprice;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param costprice null
     */
    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return packetqty null
     */
    public BigDecimal getPacketqty() {
        return packetqty;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param packetqty null
     */
    public void setPacketqty(BigDecimal packetqty) {
        this.packetqty = packetqty;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return boxqty null
     */
    public BigDecimal getBoxqty() {
        return boxqty;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param boxqty null
     */
    public void setBoxqty(BigDecimal boxqty) {
        this.boxqty = boxqty;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return flowid null
     */
    public Integer getFlowid() {
        return flowid;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param flowid null
     */
    public void setFlowid(Integer flowid) {
        this.flowid = flowid;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return frprice null
     */
    public BigDecimal getFrprice() {
        return frprice;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param frprice null
     */
    public void setFrprice(BigDecimal frprice) {
        this.frprice = frprice;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @return exrate null
     */
    public BigDecimal getExrate() {
        return exrate;
    }

    /**
     * null
     * @author gqf_ds
     * @date 2019-09-03 15:03:10
     * @param exrate null
     */
    public void setExrate(BigDecimal exrate) {
        this.exrate = exrate;
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
        sb.append(", seatid=").append(seatid);
        sb.append(", saleqty=").append(saleqty);
        sb.append(", saleprice=").append(saleprice);
        sb.append(", saletax=").append(saletax);
        sb.append(", costprice=").append(costprice);
        sb.append(", packetqty=").append(packetqty);
        sb.append(", boxqty=").append(boxqty);
        sb.append(", flowid=").append(flowid);
        sb.append(", frprice=").append(frprice);
        sb.append(", exrate=").append(exrate);
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
        WholesaleDetailDs other = (WholesaleDetailDs) that;
        return (this.getWholesaleid() == null ? other.getWholesaleid() == null : this.getWholesaleid().equals(other.getWholesaleid()))
            && (this.getProid() == null ? other.getProid() == null : this.getProid().equals(other.getProid()))
            && (this.getSeatid() == null ? other.getSeatid() == null : this.getSeatid().equals(other.getSeatid()))
            && (this.getSaleqty() == null ? other.getSaleqty() == null : this.getSaleqty().equals(other.getSaleqty()))
            && (this.getSaleprice() == null ? other.getSaleprice() == null : this.getSaleprice().equals(other.getSaleprice()))
            && (this.getSaletax() == null ? other.getSaletax() == null : this.getSaletax().equals(other.getSaletax()))
            && (this.getCostprice() == null ? other.getCostprice() == null : this.getCostprice().equals(other.getCostprice()))
            && (this.getPacketqty() == null ? other.getPacketqty() == null : this.getPacketqty().equals(other.getPacketqty()))
            && (this.getBoxqty() == null ? other.getBoxqty() == null : this.getBoxqty().equals(other.getBoxqty()))
            && (this.getFlowid() == null ? other.getFlowid() == null : this.getFlowid().equals(other.getFlowid()))
            && (this.getFrprice() == null ? other.getFrprice() == null : this.getFrprice().equals(other.getFrprice()))
            && (this.getExrate() == null ? other.getExrate() == null : this.getExrate().equals(other.getExrate()));
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
        result = prime * result + ((getSeatid() == null) ? 0 : getSeatid().hashCode());
        result = prime * result + ((getSaleqty() == null) ? 0 : getSaleqty().hashCode());
        result = prime * result + ((getSaleprice() == null) ? 0 : getSaleprice().hashCode());
        result = prime * result + ((getSaletax() == null) ? 0 : getSaletax().hashCode());
        result = prime * result + ((getCostprice() == null) ? 0 : getCostprice().hashCode());
        result = prime * result + ((getPacketqty() == null) ? 0 : getPacketqty().hashCode());
        result = prime * result + ((getBoxqty() == null) ? 0 : getBoxqty().hashCode());
        result = prime * result + ((getFlowid() == null) ? 0 : getFlowid().hashCode());
        result = prime * result + ((getFrprice() == null) ? 0 : getFrprice().hashCode());
        result = prime * result + ((getExrate() == null) ? 0 : getExrate().hashCode());
        return result;
    }
}