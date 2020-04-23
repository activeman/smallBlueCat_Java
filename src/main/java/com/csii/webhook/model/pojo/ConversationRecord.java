package com.csii.webhook.model.pojo;

import com.alibaba.da.coin.ide.spi.meta.ResultType;


import java.io.Serializable;
import java.util.List;

public class ConversationRecord implements Serializable {
    private int conversationRecordId;
    private Long botId;
    private String userInputUtterance;
    private String replyUtterance;
    private Long domainId;
    private Long intentId;
    private String intentName;
    private Long timestamp;
    private ResultType resultType;
    private List<SlotEntity> slotEntities;
    private int taskQueryId;

    public ConversationRecord() {
    }

    public ConversationRecord(Long botId, String userInputUtterance, String replyUtterance, Long domainId, Long intentId, String intentName, Long timestamp, ResultType resultType, List<SlotEntity> slotEntities) {
        this.botId = botId;
        this.userInputUtterance = userInputUtterance;
        this.replyUtterance = replyUtterance;
        this.domainId = domainId;
        this.intentId = intentId;
        this.intentName = intentName;
        this.timestamp = timestamp;
        this.resultType = resultType;
        this.slotEntities = slotEntities;
    }

    public ConversationRecord(Long botId, String userInputUtterance, String replyUtterance, Long domainId, Long intentId, String intentName, Long timestamp, ResultType resultType, List<SlotEntity> slotEntities, int taskQueryId) {
        this.botId = botId;
        this.userInputUtterance = userInputUtterance;
        this.replyUtterance = replyUtterance;
        this.domainId = domainId;
        this.intentId = intentId;
        this.intentName = intentName;
        this.timestamp = timestamp;
        this.resultType = resultType;
        this.slotEntities = slotEntities;
        this.taskQueryId = taskQueryId;
    }

    public int getConversationRecordId() {
        return conversationRecordId;
    }

    public void setConversationRecordId(int conversationRecordId) {
        this.conversationRecordId = conversationRecordId;
    }

    public int getTaskQueryId() {
        return taskQueryId;
    }

    public void setTaskQueryId(int taskQueryId) {
        this.taskQueryId = taskQueryId;
    }

    public Long getBotId() {
        return this.botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }

    public String getUserInputUtterance() {
        return this.userInputUtterance;
    }

    public void setUserInputUtterance(String userInputUtterance) {
        this.userInputUtterance = userInputUtterance;
    }

    public String getReplyUtterance() {
        return this.replyUtterance;
    }

    public void setReplyUtterance(String replyUtterance) {
        this.replyUtterance = replyUtterance;
    }

    public Long getDomainId() {
        return this.domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public Long getIntentId() {
        return this.intentId;
    }

    public void setIntentId(Long intentId) {
        this.intentId = intentId;
    }

    public String getIntentName() {
        return this.intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public ResultType getResultType() {
        return this.resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public List<SlotEntity> getSlotEntities() {
        return this.slotEntities;
    }

    public void setSlotEntities(List<SlotEntity> slotEntities) {
        this.slotEntities = slotEntities;
    }
}
