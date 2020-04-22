package com.csii.webhook.model.pojo;

import java.io.Serializable;

public class TaskQueryReqData implements Serializable {
    private int reuqestid ;
    private String mapkey;
    private String mapvalue;
    private int taskQueryId;

    public TaskQueryReqData() {
    }

    public TaskQueryReqData(int reuqestid, String mapkey, String mapvalue, int taskQueryId) {
        this.reuqestid = reuqestid;
        this.mapkey = mapkey;
        this.mapvalue = mapvalue;
        this.taskQueryId = taskQueryId;
    }

    public int getReuqestid() {
        return reuqestid;
    }

    public void setReuqestid(int reuqestid) {
        this.reuqestid = reuqestid;
    }

    public String getMapkey() {
        return mapkey;
    }

    public void setMapkey(String mapkey) {
        this.mapkey = mapkey;
    }

    public String getMapvalue() {
        return mapvalue;
    }

    public void setMapvalue(String mapvalue) {
        this.mapvalue = mapvalue;
    }

    public int getTaskQueryId() {
        return taskQueryId;
    }

    public void setTaskQueryId(int taskQueryId) {
        this.taskQueryId = taskQueryId;
    }

    @Override
    public String toString() {
        return "TaskQueryReqData{" +
                "reuqestid=" + reuqestid +
                ", mapkey='" + mapkey + '\'' +
                ", mapvalue='" + mapvalue + '\'' +
                ", taskQueryId=" + taskQueryId +
                '}';
    }
}
