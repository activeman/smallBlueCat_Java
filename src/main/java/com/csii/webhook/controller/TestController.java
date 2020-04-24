package com.csii.webhook.controller;



import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.csii.webhook.model.pojo.*;
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
    private RedisTemplate<String, BusinessQuery> businessQueryRedisTemplate;
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
         long b = 123;
         int cd =1;
        ResultType r1 = ResultType.ASK_INF;
        ConversationRecord c1 = new ConversationRecord(b,"a","a",b,b,"n",b,r1,slotEntities);
        ConversationRecord c2 = new ConversationRecord(b,"a","a",b,b,"n",b,r1,slotEntities);
        conversationRecords.add(0,c1);
        conversationRecords.add(1,c2);
        taskQuery.setConversationRecords(conversationRecords);
        //插入  Map<String, SessionEntry> sessionEntries;
        Map<String, SessionEntry> sessionEntries = new HashMap<>();
        int timeToLive =1,timeToLive2 =2,liveTime =1,liveTime2=2,taskqueryid =0;
        long cdf = 123,cdf2=345;
        SessionEntry ss1 = new SessionEntry(timeToLive,liveTime,cdf,"ss1","",taskqueryid);
        SessionEntry ss2 = new SessionEntry(timeToLive2,liveTime2,cdf2,"ss2","",taskqueryid);
        sessionEntries.put("ss1",ss1);
        sessionEntries.put("ss2",ss2);
        taskQuery.setSessionEntries(sessionEntries);
        System.out.println(taskQuery);
        String code = testService.saveTaskQuery(taskQuery);

        result.put("code",code);
        return result;
    }

    @RequestMapping("/selTaskQuery")
    public Map<Object, Object> selTaskQuery(int  taskQueryId){
        return testService.selTaskQuery(taskQueryId);
    }

    @RequestMapping("/saveRedisTask")
    public Map<Object, Object> saveRedisTask(BusinessQuery businessQuery){
        Map<Object,Object> map = new HashMap<>();
        String []token1 = businessQuery.getToken().split("\\.");
        String str = token1[2];
        String key = businessQuery.getDeviceOpenId()+str;
        businessQueryRedisTemplate.opsForValue().set(key,businessQuery);
        BusinessQuery b1 = businessQueryRedisTemplate.opsForValue().get(key);
        Map<String, SlotEntity> SlotEntities =new HashMap<>();
        long a =1,b=2;
        SlotEntity s1 = new SlotEntity(a,"1","1","1",1,a,"1","1",1);
        SlotEntity s2 = new SlotEntity(b,"2","2","2",2,b,"2","2",2);
        SlotEntities.put("s1",s1);
        SlotEntities.put("s2",s2);
        businessQuery.setSlotEntities(SlotEntities);
        if(b1==null){
            map.put("code","9999");
            map.put("msg","存储失败");
        }else {
            map.put("code","0000");
            map.put("msg","存储成功");
            map.put(key,businessQuery);
        }
        System.out.println(str);

        map.put(key,businessQuery);
        return map;
    }
}
