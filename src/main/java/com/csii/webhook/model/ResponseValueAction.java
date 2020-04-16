package com.csii.webhook.model;

import java.util.HashMap;

/**
 * @author 571002868
 */
public class ResponseValueAction {
    private String name;                             //1，Action名，该名字必须设置为“audioPlayGenieSource”
    private HashMap<String,String> properties;       //1，Action中的信息字段，“audioGenieId”的key必须设置，标示播放的开放平台存储的音频ID

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }
}
