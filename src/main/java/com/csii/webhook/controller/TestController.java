package com.csii.webhook.controller;

import com.csii.webhook.model.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @RequestMapping("/testRedis1")
    public void testRedis1(){
     stringRedisTemplate.opsForValue().set("hello","你好！");
     String str = stringRedisTemplate.opsForValue().get("helo");
        System.out.println(str);
        stringRedisTemplate.opsForList().leftPush("list1","23");
        stringRedisTemplate.opsForList().leftPush("list1","23");
    }

    @RequestMapping("/testRedis2")
    public void testRedis2(){
        Users users =new Users();
        users.setId(1);
        users.setName("wxt");
        users.setAge(12);
        users.setLogin("123");
        users.setPassword("123");
        redisTemplate.opsForValue().set("u1",users);
    }
}
