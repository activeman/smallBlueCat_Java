package com.csii.webhook.model;

import java.util.HashMap;

/**
 * @author 571002868
 */
public class ResponseValue {
    private String reply;                              //1，回复播报语句 ***
    private String resultType;                         //1，回复时的状态标识（ASK_INF：信息获取，例如“请问从哪个城市出发”，在此状态下，用户说的下一句话优先进入本意图进行有效信息抽取 RESULT：正常完成交互的阶段并给出回复 CONFIRM：期待确认）
    private HashMap<String,String> properties;         //0，生成回复语句时携带的额外信息
    private ResponseValueAskedInfo []askedInfos;       //0，在ASK_INF状态下，必须设置本次追问的具体参数名（开发者平台意图参数下配置的参数信息）	在ASK_INF状态下必须
    private ResponseValueAction []actions;             //0，播控类信息，目前只支持播放音频
    private String executeCode;                        //1，“SUCCESS”代表执行成功；“PARAMS_ERROR”代表接收到的请求参数出错；“EXECUTE_ERROR”代表自身代码有异常；“REPLY_ERROR”代表回复结果生成出错

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    public ResponseValueAskedInfo[] getAskedInfos() {
        return askedInfos;
    }

    public void setAskedInfos(ResponseValueAskedInfo[] askedInfos) {
        this.askedInfos = askedInfos;
    }

    public ResponseValueAction[] getActions() {
        return actions;
    }

    public void setActions(ResponseValueAction[] actions) {
        this.actions = actions;
    }

    public String getExecuteCode() {
        return executeCode;
    }

    public void setExecuteCode(String executeCode) {
        this.executeCode = executeCode;
    }
}
