package com.csii.webhook.controller;


import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.csii.webhook.model.pojo.*;
import com.csii.webhook.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

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


    //ls-test
    @RequestMapping("/tr")
    @ResponseBody
    public Map<String, Object> testRedisX() {


        //向redis里存入数据和设置缓存时间
        stringRedisTemplate.opsForValue().set("baike", "100", 60 * 2, TimeUnit.SECONDS);
        //val做-1操作
        stringRedisTemplate.boundValueOps("baike").increment(-1);
        //根据key获取缓存中的val
        stringRedisTemplate.opsForValue().get("baike");
        //val +1
        stringRedisTemplate.boundValueOps("baike").increment(1);

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //根据key获取过期时间
        Long to=stringRedisTemplate.getExpire("baike");
        System.out.println(to);

        stringRedisTemplate.expire("baike",60 * 2, TimeUnit.SECONDS);
        to=stringRedisTemplate.getExpire("baike");
        System.out.println(to);

        //根据key获取过期时间并换算成指定单位
        stringRedisTemplate.getExpire("baike", TimeUnit.SECONDS);
        //根据key删除缓存
        stringRedisTemplate.delete("baike");
        //检查key是否存在，返回boolean值
        Boolean bo= stringRedisTemplate.hasKey("baike");
        System.out.println(bo);
        //向指定key中存放set集合
        stringRedisTemplate.opsForSet().add("baike", "1", "2", "3");
        //设置过期时间
        stringRedisTemplate.expire("baike", 60 , TimeUnit.SECONDS);
        //根据key查看集合中是否存在指定数据
        stringRedisTemplate.opsForSet().isMember("baike", "1");
        //根据key获取set集合
        Set<String> baike = stringRedisTemplate.opsForSet().members("baike");
        for (String str : baike) {
            System.out.println(str);
        }

        return new HashMap<String, Object>() {{
            put("hello", 666);
        }};
    }
}
