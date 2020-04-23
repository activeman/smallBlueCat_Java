package com.csii.webhook.service.impl;



import com.csii.webhook.dao.TestDao;
import com.csii.webhook.model.pojo.ConversationRecord;
import com.csii.webhook.model.pojo.SessionEntry;
import com.csii.webhook.model.pojo.SlotEntity;
import com.csii.webhook.model.pojo.TaskQuery;
import com.csii.webhook.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

        }
        System.out.println("================"+"----------------");
        List<SlotEntity> slotEntities = taskQuery.getSlotEntities();
        for(SlotEntity slotEntity:slotEntities){
            slotEntity.setTaskqueryid(taskQueryId);
        }
        while (k!=slotEntities.size()){
            k= testDao.saveTaskQuerySlotEntity(slotEntities);
        }
        System.out.println("taskquery的SlotEntity集合插入成功");
        List<ConversationRecord> conversationRecords =  taskQuery.getConversationRecords();
        for (ConversationRecord conversationRecord:conversationRecords) {
            conversationRecord.setTaskQueryId(taskQueryId);
        }
        while(g!=conversationRecords.size()){
            g= testDao.saveTaskQueryConRcdEntity(conversationRecords);
        }
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
}
