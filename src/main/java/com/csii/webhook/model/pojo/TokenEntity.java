package com.csii.webhook.model.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@PropertySource("classpath:application.properties")
public class TokenEntity implements Serializable {
    @Value("${token.secret}")
    private String secret;

//    @Value("${expire.time}")
//    private String time;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }


}
