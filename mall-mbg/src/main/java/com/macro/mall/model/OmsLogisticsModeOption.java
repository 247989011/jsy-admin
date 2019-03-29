package com.macro.mall.model;

import java.io.Serializable;
import java.util.Date;

public class OmsLogisticsModeOption implements Serializable {
    /**
     * 主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 订单ID
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * 物流模式ID
     *
     * @mbggenerated
     */
    private Long logisticsModeId;

    private Date lastCreateTime;

    private String lastCreateId;

    private Date lastUpdateTime;

    private String lastUpdateId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getLogisticsModeId() {
        return logisticsModeId;
    }

    public void setLogisticsModeId(Long logisticsModeId) {
        this.logisticsModeId = logisticsModeId;
    }

    public Date getLastCreateTime() {
        return lastCreateTime;
    }

    public void setLastCreateTime(Date lastCreateTime) {
        this.lastCreateTime = lastCreateTime;
    }

    public String getLastCreateId() {
        return lastCreateId;
    }

    public void setLastCreateId(String lastCreateId) {
        this.lastCreateId = lastCreateId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", logisticsModeId=").append(logisticsModeId);
        sb.append(", lastCreateTime=").append(lastCreateTime);
        sb.append(", lastCreateId=").append(lastCreateId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateId=").append(lastUpdateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}