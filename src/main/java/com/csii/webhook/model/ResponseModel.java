package com.csii.webhook.model;

/**
 * @author 571002868
 */
public class ResponseModel {
    private RequestModel req;
    private String returnCode;                    //1,“0”默认表示成功，其他不成功的字段自己可以确定
    private String returnErrorSolution;           //0，出错时解决办法的描述信息
    private String returnMessage;                 //0，返回执行成功的描述信息
    private ResponseValue returnValue;                   //1，意图理解后的执行结果

    public RequestModel getReq() {
        return req;
    }

    public void setReq(RequestModel req) {
        this.req = req;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnErrorSolution() {
        return returnErrorSolution;
    }

    public void setReturnErrorSolution(String returnErrorSolution) {
        this.returnErrorSolution = returnErrorSolution;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public ResponseValue getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(ResponseValue returnValue) {
        this.returnValue = returnValue;
    }
}
