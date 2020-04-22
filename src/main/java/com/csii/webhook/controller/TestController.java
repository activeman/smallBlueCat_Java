package com.csii.webhook.controller;



import com.csii.webhook.model.pojo.ConversationRecord;
import com.csii.webhook.model.pojo.SlotEntity;
import com.csii.webhook.model.pojo.TaskQuery;
import com.csii.webhook.model.pojo.Users;
import com.csii.webhook.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object,Users> redisTemplate;
    @Autowired
    private TestService testService;
    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    //存取redis字符串
    @RequestMapping("/testRedis1")
    public void testRedis1(){
        //存redis字符串
     stringRedisTemplate.opsForValue().set("hello","你好！");
     //取redis字符串
     String str = stringRedisTemplate.opsForValue().get("helo");
        System.out.println(str);
        stringRedisTemplate.opsForList().leftPush("list1","23");
        stringRedisTemplate.opsForList().leftPush("list1","23");
    }
    //存储redis对象
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
    //获取redis存取对象
    @RequestMapping("/testRedis3")
    public void testRedis3(){
      Users users =  redisTemplate.opsForValue().get("u1");
        System.out.println(users);
    }

    @RequestMapping("/saveTaskQuery")
    public Map<String, String> saveTaskQuery(TaskQuery taskQuery){
        Map<String,String> result = new HashMap<>();
        Map<String,String> result1 = new HashMap<>();
        result1.put("1","金融秘书");
        result1.put("2","金融管家");
        taskQuery.setRequestData(result1);
        List<SlotEntity> slotEntities =new  ArrayList<SlotEntity>();
        long a =1234;
        SlotEntity s1 = new SlotEntity(a,"a","a","a",1,a,"a","a",1);
        SlotEntity s2 = new SlotEntity(a,"b","b","b",1,a,"a","a",1);
        slotEntities.add(0,s1);
        slotEntities.add(1,s2);
        taskQuery.setSlotEntities(slotEntities);

        List<ConversationRecord> conversationRecords =new  ArrayList<ConversationRecord>();
        ConversationRecord c1 = new ConversationRecord();
        System.out.println(taskQuery);
        String code = testService.saveTaskQuery(taskQuery);

        result.put("code",code);
        return result;
    }
}
