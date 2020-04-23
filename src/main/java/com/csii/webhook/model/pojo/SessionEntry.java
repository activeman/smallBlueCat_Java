package com.csii.webhook.model.pojo;

import java.io.Serializable;

public class SessionEntry implements Serializable {

    private int sessionentryid;
    private Integer timeToLive;
    private Integer liveTime = 0;
    private Long timeStamp;
    private String value;
    private String sessionkey;
    private int taskQueryId;

    public SessionEntry() {
    }



    public SessionEntry(Integer timeToLive, Integer liveTime, Long timeStamp, String value, String sessionkey, int taskQueryId) {
        this.timeToLive = timeToLive;
        this.liveTime = liveTime;
        this.timeStamp = timeStamp;
        this.value = value;
        this.sessionkey = sessionkey;
        this.taskQueryId = taskQueryId;
    }


    public int getSessionentryid() {
        return sessionentryid;
    }

    public void setSessionentryid(int sessionentryid) {
        this.sessionentryid = sessionentryid;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    public int getTaskQueryId() {
        return taskQueryId;
    }

    public void setTaskQueryId(int taskQueryId) {
        this.taskQueryId = taskQueryId;
    }

    public Integer getTimeToLive() {
        return this.timeToLive;
    }

    public void setTimeToLive(Integer timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Integer getLiveTime() {
        return this.liveTime;
    }

    public void setLiveTime(Integer liveTime) {
        this.liveTime = liveTime;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SessionEntry{" +
                "sessionentryid=" + sessionentryid +
                ", timeToLive=" + timeToLive +
                ", liveTime=" + liveTime +
                ", timeStamp=" + timeStamp +
                ", value='" + value + '\'' +
                ", sessionkey='" + sessionkey + '\'' +
                ", taskQueryId=" + taskQueryId +
                '}';
    }
}
