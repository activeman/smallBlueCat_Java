package com.csii.webhook.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.csii.webhook.model.pojo.TokenEntity;
import com.csii.webhook.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TokenEntity tokenentity;
    @Override
    public String sign(String username) {

        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(tokenentity.getSecret());
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        String token = JWT.create().withHeader(header)//设置头
                .withClaim("user", username)//设置自定义字段
                .sign(algorithm);//设置加密字段
        return token;
    }
}
