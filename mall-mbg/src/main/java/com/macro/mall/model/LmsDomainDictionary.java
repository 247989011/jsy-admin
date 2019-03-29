package com.macro.mall.model;

import java.io.Serializable;

public class LmsDomainDictionary implements Serializable {
    private Long id;

    /**
     * 术语类型(分类或归类)
     *
     * @mbggenerated
     */
    private Integer keyType;

    /**
     * 术语名
     *
     * @mbggenerated
     */
    private String keyName;

    /**
     * 术语值
     *
     * @mbggenerated
     */
    private String keyValue;

    /**
     * 术语值描述
     *
     * @mbggenerated
     */
    private String keyValueDescribe;

    private String lastCreateTime;

    private String lastCreateId;

    private String lastUpdateTime;

    private String lastUpdateId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKeyType() {
        return keyType;
    }

    public void setKeyType(Integer keyType) {
        this.keyType = keyType;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyValueDescribe() {
        return keyValueDescribe;
    }

    public void setKeyValueDescribe(String keyValueDescribe) {
        this.keyValueDescribe = keyValueDescribe;
    }

    public String getLastCreateTime() {
        return lastCreateTime;
    }

    public void setLastCreateTime(String lastCreateTime) {
        this.lastCreateTime = lastCreateTime;
    }

    public String getLastCreateId() {
        return lastCreateId;
    }

    public void setLastCreateId(String lastCreateId) {
        this.lastCreateId = lastCreateId;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
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
        sb.append(", keyType=").append(keyType);
        sb.append(", keyName=").append(keyName);
        sb.append(", keyValue=").append(keyValue);
        sb.append(", keyValueDescribe=").append(keyValueDescribe);
        sb.append(", lastCreateTime=").append(lastCreateTime);
        sb.append(", lastCreateId=").append(lastCreateId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateId=").append(lastUpdateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}