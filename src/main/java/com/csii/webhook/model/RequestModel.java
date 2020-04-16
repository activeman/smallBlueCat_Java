package com.csii.webhook.model;

import java.util.HashMap;

/**
 * @author 571002868
 */
public class RequestModel {

    private String sessionId;                         //1,会话ID，session内的对话此ID相同
    private int botId;                                //1,应用ID，来自于创建的应用或者技能
    private String utterance;                         //1,用户输入语句
    private HashMap<String,String> requestData;       //0,业务请求附带参数,来自于设备调用语义理解服务额外携带的信息，只做透传
    private int domainId;                             //1,领域ID
    private int skillId;                              //1,技能ID
    private String skillName;                         //1,技能名称
    private int intentId;                             //1,意图ID
    private String intentName;                        //1,意图名称
    private RequestSlotEntitie [] slotEntities;        //1,从用户语句中抽取出的slot参数信息
    private String requestId;                         //1,请求Id
    private HashMap<String,String> device;
    private String token;                             //0,技能鉴权token，可以不需要，如果有安全需求需要配置

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getBotId() {
        return botId;
    }

    public void setBotId(int botId) {
        this.botId = botId;
    }

    public String getUtterance() {
        return utterance;
    }

    public void setUtterance(String utterance) {
        this.utterance = utterance;
    }

    public HashMap<String, String> getRequestData() {
        return requestData;
    }

    public void setRequestData(HashMap<String, String> requestData) {
        this.requestData = requestData;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getIntentId() {
        return intentId;
    }

    public void setIntentId(int intentId) {
        this.intentId = intentId;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public RequestSlotEntitie[] getSlotEntities() {
        return slotEntities;
    }

    public void setSlotEntities(RequestSlotEntitie[] slotEntities) {
        this.slotEntities = slotEntities;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public HashMap<String, String> getDevice() {
        return device;
    }

    public void setDevice(HashMap<String, String> device) {
        this.device = device;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
