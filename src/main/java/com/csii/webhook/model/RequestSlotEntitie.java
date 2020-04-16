package com.csii.webhook.model;

public class RequestSlotEntitie {
    private int intentParameterId;              //1,意图参数ID
    private String intentParameterName;         //1,意图参数名->意图的名字
    private String originalValue;               //1,原始句子中抽取出来的未做处理的slot值
    private String standardValue;               //1,原始slot归一化后的值
    private int liveTime;                       //1,该slot已生存时间（会话轮数）
    private int createTimeStamp;                //1,该slot产生的时间点
    private String slotName;                    //1,slot名称
    private String slotValue;                   //1,slot值

    public int getIntentParameterId() {
        return intentParameterId;
    }

    public void setIntentParameterId(int intentParameterId) {
        this.intentParameterId = intentParameterId;
    }

    public String getIntentParameterName() {
        return intentParameterName;
    }

    public void setIntentParameterName(String intentParameterName) {
        this.intentParameterName = intentParameterName;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public String getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }

    public int getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(int liveTime) {
        this.liveTime = liveTime;
    }

    public int getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(int createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public String getSlotValue() {
        return slotValue;
    }

    public void setSlotValue(String slotValue) {
        this.slotValue = slotValue;
    }
}
