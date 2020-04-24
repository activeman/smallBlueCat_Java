package com.csii.webhook.service.impl;



import com.csii.webhook.dao.TestDao;
import com.csii.webhook.model.pojo.*;
import com.csii.webhook.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public String saveTaskQuery(TaskQuery taskQuery) {
        int i = 0,j=0,k=0,g =0,p=0;
        String str = "9999";
        //插入taskquery实体类
        i = testDao.saveTaskQuery(taskQuery);
        //判断插入是否成功
        while(i<=0){
            i = testDao.saveTaskQuery(taskQuery);
        }
        //获取插入成功的那条记录主键id
        int taskQueryId = taskQuery.getTaskQueryId();
        System.out.println("taskqueryid插入成功数据:++++++++++++++++++"+i);
        System.out.println("taskqueryid插入返回主键:++++++++++++++++++"+taskQueryId);
        //插入taskquery requestdata
        Map<String,String> reqMap = taskQuery.getRequestData();
        String key = null;
        String value= null;
        //遍历插入 Map
        for (Map.Entry<String, String> entry : reqMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            key = entry.getKey();
            value = entry.getValue();
            while (j==0){
            j = testDao.saveTaskQueryReqMapData(taskQueryId,key,value);
            }
            //遍历第二次让j=0 不然不能插入
            j=0;
        }
        System.out.println("================"+"----------------");
        List<SlotEntity> slotEntities = taskQuery.getSlotEntities();
        for(SlotEntity slotEntity:slotEntities){
            slotEntity.setTaskqueryid(taskQueryId);
        }
        // k是在xml 里面用迭代器批量插入返回受影响行数
        while (k!=slotEntities.size()){
            k= testDao.saveTaskQuerySlotEntity(slotEntities);
        }
        System.out.println("taskquery的SlotEntity集合插入成功");
        List<ConversationRecord> conversationRecords =  taskQuery.getConversationRecords();
        for (ConversationRecord conversationRecord:conversationRecords) {
            conversationRecord.setTaskQueryId(taskQueryId);
        }
        // g是在xml 里面用迭代器批量插入返回受影响行数
        while(g!=conversationRecords.size()){
            g= testDao.saveTaskQueryConRcdEntity(conversationRecords);
            System.out.println("========g+-------"+g);
        }
        System.out.println("========g+========"+g);
        System.out.println("taskquery的conversationRecord插入成功");
        //插入session
        Map<String, SessionEntry> sessionMap = taskQuery.getSessionEntries();
        String sessionkey = null;
        SessionEntry sessionvalue= new SessionEntry();
//        //遍历插入 Map
        for (Map.Entry<String, SessionEntry> entry : sessionMap.entrySet()) {

            key = entry.getKey();
            sessionvalue = entry.getValue();
            //map集合key值
            sessionvalue.setSessionkey(key);
            //设置插入外键的值
            sessionvalue.setTaskQueryId(taskQueryId);
            System.out.println("需要插入的参数："+sessionvalue);
            while (p==0){
                p = testDao.saveTaskQuerySessionEntry(sessionvalue);
            }
            System.out.println("本次需要插入的参数："+sessionvalue+"插入结果"+p+"插入成功返回主键"+sessionvalue.getSessionentryid());
            p=0;
        }
        if(i>0){
          str ="0000";
        }
        return str;
    }

    //查询taskQuery
    @Override
    public Map<Object, Object> selTaskQuery(int taskQueryId) {
        Map<Object, Object> map = new HashMap<>();
        TaskQuery taskQuery = testDao.selTaskQuery(taskQueryId);
        System.out.println("初次查询输出"+taskQuery);
        //查询TaskQuery 的requestData 属性
        List<RequestData>requestData = testDao.selTaskQueryReqData(taskQueryId);
        Map <String,String> reqmap = new HashMap<>();
        for (RequestData req:requestData) {
            reqmap.put(req.getMapkey(),req.getMapvalue());
        }
        taskQuery.setRequestData(reqmap);
        System.out.println("第二次输出"+taskQuery);
        List<SessionEntry>sessionEntries = testDao.selTaskQuerySessionList(taskQueryId);
        Map<String ,SessionEntry>sessionEntryMap = new HashMap<>();
        for (SessionEntry session:sessionEntries) {
            sessionEntryMap.put(session.getSessionkey(),session);
        }
        taskQuery.setSessionEntries(sessionEntryMap);
        //
        System.out.println(taskQuery);
        map.put("code","0000");
        map.put("msg","查询成功");
        map.put(taskQueryId,taskQuery);
        return map;
    }
    @Autowired
    private RedisTemplate<String, BusinessQuery> businessQueryRedisTemplate;

    @Override
    public Map<Object, Object> savebusness(BusinessQuery businessQuery) {
        Map<Object,Object> map = new HashMap<>();
        String []token1 = businessQuery.getToken().split("\\.");
        String str = token1[2];
        String key = businessQuery.getDeviceOpenId()+str;
        businessQueryRedisTemplate.opsForValue().set(key,businessQuery);
        BusinessQuery b1 = businessQueryRedisTemplate.opsForValue().get(key);
        if(b1==null){
            map.put("code","9999");
            map.put("msg","存储失败");
        }else {
            map.put("code","0000");
            map.put("msg","存储成功");
            map.put(key,businessQuery);
        }
        return map;
    }


}
