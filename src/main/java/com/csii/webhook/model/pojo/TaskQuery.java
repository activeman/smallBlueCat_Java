package com.csii.webhook.model.pojo;

import com.csii.webhook.model.pojo.ConversationRecord;
import com.csii.webhook.model.pojo.SessionEntry;
import com.csii.webhook.model.pojo.SlotEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TaskQuery implements Serializable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskQueryId;
    private String sessionId;
    private String utterance;
    private Long skillId;
    private String skillName;
    private String token;
    private Long intentId;
    private String intentName;
    private Map<String, String> requestData = null;
    private List<SlotEntity> slotEntities = null;
    private List<ConversationRecord> conversationRecords = null;
    private Map<String, SessionEntry> sessionEntries;
    private Long botId;
    private Long domainId;

    public TaskQuery() {
    }

    public TaskQuery(String sessionId, String utterance, Long skillId, String skillName, String token, Long intentId, String intentName, Map<String, String> requestData, List<SlotEntity> slotEntities, List<ConversationRecord> conversationRecords, Map<String, SessionEntry> sessionEntries, Long botId, Long domainId) {
        this.sessionId = sessionId;
        this.utterance = utterance;
        this.skillId = skillId;
        this.skillName = skillName;
        this.token = token;
        this.intentId = intentId;
        this.intentName = intentName;
        this.requestData = requestData;
        this.slotEntities = slotEntities;
        this.conversationRecords = conversationRecords;
        this.sessionEntries = sessionEntries;
        this.botId = botId;
        this.domainId = domainId;
    }

    public TaskQuery(int taskQueryId, String sessionId, String utterance, Long skillId, String skillName, String token, Long intentId, String intentName, Map<String, String> requestData, List<SlotEntity> slotEntities, List<ConversationRecord> conversationRecords, Map<String, SessionEntry> sessionEntries, Long botId, Long domainId) {
        this.taskQueryId = taskQueryId;
        this.sessionId = sessionId;
        this.utterance = utterance;
        this.skillId = skillId;
        this.skillName = skillName;
        this.token = token;
        this.intentId = intentId;
        this.intentName = intentName;
        this.requestData = requestData;
        this.slotEntities = slotEntities;
        this.conversationRecords = conversationRecords;
        this.sessionEntries = sessionEntries;
        this.botId = botId;
        this.domainId = domainId;
    }

    public int getTaskQueryId() {
        return taskQueryId;
    }

    public void setTaskQueryId(int taskQueryId) {
        this.taskQueryId = taskQueryId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getBotId() {
        return this.botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }

    public String getUtterance() {
        return this.utterance;
    }

    public void setUtterance(String utterance) {
        this.utterance = utterance;
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

    public Map<String, String> getRequestData() {
        return this.requestData;
    }

    public void setRequestData(Map<String, String> requestData) {
        this.requestData = requestData;
    }

    public List<SlotEntity> getSlotEntities() {
        return this.slotEntities;
    }

    public void setSlotEntities(List<SlotEntity> slotEntities) {
        this.slotEntities = slotEntities;
    }

    public List<ConversationRecord> getDialogRecords() {
        return this.conversationRecords;
    }

    public void setDialogRecords(List<ConversationRecord> conversationRecords) {
        this.conversationRecords = conversationRecords;
    }

    public Map<String, SessionEntry> getSessionEntries() {
        return this.sessionEntries;
    }

    public void setSessionEntries(Map<String, SessionEntry> sessionEntries) {
        this.sessionEntries = sessionEntries;
    }

    public Long getSkillId() {
        return this.skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public List<ConversationRecord> getConversationRecords() {
        return this.conversationRecords;
    }

    public void setConversationRecords(List<ConversationRecord> conversationRecords) {
        this.conversationRecords = conversationRecords;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "TaskQuery [sessionId=" + this.sessionId + ", utterance=" + this.utterance + ", skillId=" + this.skillId + ", skillName=" + this.skillName + ", token=" + this.token + ", intentId=" + this.intentId + ", intentName=" + this.intentName + ", requestData=" + this.requestData + ", slotEntities=" + this.slotEntities + ", conversationRecords=" + this.conversationRecords + ", sessionEntries=" + this.sessionEntries + ", botId=" + this.botId + ", domainId=" + this.domainId + "]";
    }
}
