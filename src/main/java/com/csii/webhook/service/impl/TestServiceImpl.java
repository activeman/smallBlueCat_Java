package com.csii.webhook.service.impl;



import com.csii.webhook.dao.TestDao;
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
        int i = 0,j=0,k=0;
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
            j = testDao.saveTaskQueryReqMapData(taskQueryId,key,value);
        }
        System.out.println("================"+"----------------");
        List<SlotEntity> slotEntities = taskQuery.getSlotEntities();
        k= testDao.saveTaskQuerySlotEntity(slotEntities);
        System.out.println(k);
        if(i>0){
          str ="0000";
        }
        return str;
    }
}
