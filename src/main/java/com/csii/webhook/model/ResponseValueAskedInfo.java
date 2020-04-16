package com.csii.webhook.model;

/**
 * @author 571002868
 */
public class ResponseValueAskedInfo {
    private String parameterName;    //1，询问的参数名（非实体名）
    private int intentId;            //1，意图ID，从请求参数中可以获得

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public int getIntentId() {
        return intentId;
    }

    public void setIntentId(int intentId) {
        this.intentId = intentId;
    }
}
