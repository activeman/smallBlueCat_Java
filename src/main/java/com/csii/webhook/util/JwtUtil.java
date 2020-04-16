package com.csii.webhook.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import sun.security.krb5.internal.crypto.Aes128;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushuai on 2020/1/19.
 */

public class JwtUtil {


    /**
     * 过期时间为一天
     * private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;
     * TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 15 * 60 * 1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "joijsdfjlsjfljfljl5135313135";

    /**
     * 生成签名,15分钟后过期
     *
     * @param username
     * @param userId
     * @return
     */
    public static String sign(String username, String userId) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim("loginName", username).withSubject("ls").withClaim("userId", userId).withExpiresAt(date).sign(algorithm);
    }

    public static boolean verity(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            System.out.println("verity....");
            System.out.println(jwt.getToken());
            System.out.println(jwt.getHeader());
            System.out.println(jwt.getPayload());
            System.out.println(jwt.getSignature());
            System.out.println("-------------------");
            Map<String, Claim> map = jwt.getClaims();

            map.forEach((k, v) -> System.out.println("k :" + k + " v:" + v));

            Map<String, String> resultMap = new HashMap<>(map.size());
            map.forEach((k, v) -> resultMap.put(k, v.asString()));
            System.out.println();
            resultMap.forEach((k, v) -> System.out.println(k));
            System.out.println();
            resultMap.forEach((k, v) -> System.out.println(v));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }

    }

//    /**
//     * 验证jwt，并返回数据
//     */
//    public static Map<String, String> verifyToken(String token) throws Exception {
//        Algorithm algorithm;
//        Map<String, Claim> map;
//        try {
//            algorithm = Algorithm.HMAC256(SECRET);
//            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
//            DecodedJWT jwt = verifier.verify(token);
//            map = jwt.getClaims();
//        } catch (Exception e) {
//            throw new Exception("鉴权失败");
//        }
//        Map<String, String> resultMap = new HashMap<>(map.size());
//        map.forEach((k, v) -> resultMap.put(k, v.asString()));
//        return resultMap;
//    }
}
