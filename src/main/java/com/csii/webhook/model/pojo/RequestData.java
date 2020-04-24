package com.csii.webhook.model.pojo;

public class RequestData {
    private int reuqestid;
    private String mapkey;
    private String mapvalue;
    private int taskqueryid;

    public RequestData() {
    }

    public RequestData(int reuqestid, String mapkey, String mapvalue, int taskqueryid) {
        this.reuqestid = reuqestid;
        this.mapkey = mapkey;
        this.mapvalue = mapvalue;
        this.taskqueryid = taskqueryid;
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

    public int getTaskqueryid() {
        return taskqueryid;
    }

    public void setTaskqueryid(int taskqueryid) {
        this.taskqueryid = taskqueryid;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "reuqestid=" + reuqestid +
                ", mapkey='" + mapkey + '\'' +
                ", mapvalue='" + mapvalue + '\'' +
                ", taskqueryid=" + taskqueryid +
                '}';
    }
}
