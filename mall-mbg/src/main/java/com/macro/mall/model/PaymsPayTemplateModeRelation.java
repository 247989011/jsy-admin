package com.macro.mall.model;

import java.io.Serializable;
import java.util.Date;

public class PaymsPayTemplateModeRelation implements Serializable {
    private Long id;

    private Long templateId;

    private Long modeId;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date lastCreateTime;

    /**
     * 创建者或创建模块
     *
     * @mbggenerated
     */
    private String lastCreateId;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date lastUpdateTime;

    /**
     * 更新者或更新模块
     *
     * @mbggenerated
     */
    private String lastUpdateId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getModeId() {
        return modeId;
    }

    public void setModeId(Long modeId) {
        this.modeId = modeId;
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
        sb.append(", templateId=").append(templateId);
        sb.append(", modeId=").append(modeId);
        sb.append(", lastCreateTime=").append(lastCreateTime);
        sb.append(", lastCreateId=").append(lastCreateId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateId=").append(lastUpdateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}