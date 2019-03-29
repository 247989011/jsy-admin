package com.macro.mall.model;

import java.io.Serializable;
import java.util.Date;

public class FdfsFilenameMapper implements Serializable {
    private Long id;

    private String fdfsGroup;

    private String fdfsFullPathName;

    private String originFileName;

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

    public String getFdfsGroup() {
        return fdfsGroup;
    }

    public void setFdfsGroup(String fdfsGroup) {
        this.fdfsGroup = fdfsGroup;
    }

    public String getFdfsFullPathName() {
        return fdfsFullPathName;
    }

    public void setFdfsFullPathName(String fdfsFullPathName) {
        this.fdfsFullPathName = fdfsFullPathName;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
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
        sb.append(", fdfsGroup=").append(fdfsGroup);
        sb.append(", fdfsFullPathName=").append(fdfsFullPathName);
        sb.append(", originFileName=").append(originFileName);
        sb.append(", lastCreateTime=").append(lastCreateTime);
        sb.append(", lastCreateId=").append(lastCreateId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateId=").append(lastUpdateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}