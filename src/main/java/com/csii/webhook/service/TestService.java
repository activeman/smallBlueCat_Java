package com.csii.webhook.service;


import com.csii.webhook.model.pojo.TaskQuery;
import org.springframework.stereotype.Service;

@Service
public interface TestService {
    String saveTaskQuery(TaskQuery taskQuery);
}
