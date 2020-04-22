package com.csii.webhook.model.pojo;

import java.io.Serializable;

public class SlotEntity implements Serializable {

    private int slotId;
    private Long intentParameterId;
    private String intentParameterName;
    private String originalValue;
    private String standardValue;
    private Integer liveTime;
    private Long createTimeStamp;
    private String slotName;
    private String slotValue;
    private int taskqueryid;

    public SlotEntity() {
    }

    public SlotEntity(Long intentParameterId, String intentParameterName, String originalValue, String standardValue, Integer liveTime, Long createTimeStamp, String slotName, String slotValue, int taskqueryid) {
        this.intentParameterId = intentParameterId;
        this.intentParameterName = intentParameterName;
        this.originalValue = originalValue;
        this.standardValue = standardValue;
        this.liveTime = liveTime;
        this.createTimeStamp = createTimeStamp;
        this.slotName = slotName;
        this.slotValue = slotValue;
        this.taskqueryid = taskqueryid;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getTaskqueryid() {
        return taskqueryid;
    }

    public void setTaskqueryid(int taskqueryid) {
        this.taskqueryid = taskqueryid;
    }

    public Long getIntentParameterId() {
        return this.intentParameterId;
    }

    public void setIntentParameterId(Long intentParameterId) {
        this.intentParameterId = intentParameterId;
    }

    public String getIntentParameterName() {
        return this.intentParameterName;
    }

    public void setIntentParameterName(String intentParameterName) {
        this.intentParameterName = intentParameterName;
    }

    public String getOriginalValue() {
        return this.originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public String getStandardValue() {
        return this.standardValue;
    }

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }

    public Integer getLiveTime() {
        return this.liveTime;
    }

    public void setLiveTime(Integer liveTime) {
        this.liveTime = liveTime;
    }

    public Long getCreateTimeStamp() {
        return this.createTimeStamp;
    }

    public void setCreateTimeStamp(Long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public String getSlotName() {
        return this.slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public String getSlotValue() {
        return this.slotValue;
    }

    public void setSlotValue(String slotValue) {
        this.slotValue = slotValue;
    }

    @Override
    public String toString() {
        return "SlotEntity{" +
                "slotId=" + slotId +
                ", intentParameterId=" + intentParameterId +
                ", intentParameterName='" + intentParameterName + '\'' +
                ", originalValue='" + originalValue + '\'' +
                ", standardValue='" + standardValue + '\'' +
                ", liveTime=" + liveTime +
                ", createTimeStamp=" + createTimeStamp +
                ", slotName='" + slotName + '\'' +
                ", slotValue='" + slotValue + '\'' +
                ", taskqueryid=" + taskqueryid +
                '}';
    }
}
