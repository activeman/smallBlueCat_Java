package com.csii.webhook.service;


import com.csii.webhook.model.pojo.BusinessQuery;
import com.csii.webhook.model.pojo.TaskQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public interface TestService {
    //插入taskQuery
    String saveTaskQuery(TaskQuery taskQuery);
    //查询taskQuery
    Map<Object, Object> selTaskQuery(int taskQueryId);
   //存储缓存BusinessQuery
    Map<Object, Object> saveBusinessQuery(BusinessQuery businessQuery);
}
