package com.csii.webhook.model.pojo;

import java.io.Serializable;


public class TaskQuery implements Serializable {

    private String sessionId;
    private String utterance;
    private Long skillId;
    private String skillName;
    private String token;
    private Long intentId;
    private String intentName;
    private Long botId;
    private Long domainId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public String getUtterance() {
        return utterance;
    }

    public void setUtterance(String utterance) {
        this.utterance = utterance;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getIntentId() {
        return intentId;
    }

    public void setIntentId(Long intentId) {
        this.intentId = intentId;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    @Override
    public String toString() {
        return "TaskQuery{" +
                "sessionId='" + sessionId + '\'' +
                ", utterance='" + utterance + '\'' +
                ", skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", token='" + token + '\'' +
                ", intentId=" + intentId +
                ", intentName='" + intentName + '\'' +
                ", botId=" + botId +
                ", domainId=" + domainId +
                '}';
    }

}
