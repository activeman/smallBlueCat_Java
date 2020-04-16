package com.csii.webhook;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushuai on 2020/4/16.
 */
public class JWT_Test {
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

    public static void main(String[] args) {
        System.out.println("helloworld");
        String token = sign("user", "pwd");
        System.out.println("token : "+token);
        verity(token);

    }
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
        String token =JWT.create().withHeader(header)//设置头
                .withClaim("loginName", username)//设置自定义字段
                .withClaim("userId", userId)
                .withSubject("ls")
                .withExpiresAt(date)
                .sign(algorithm);//设置加密字段

        return token;
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

            map.forEach((k, v) -> System.out.println("k :" + k + "\t v:" + v.asString()));//v有各种as类型，exp要as他对应的类型才能打印，否则是null


            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }

    }
}
