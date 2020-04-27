package com.csii.webhook.service;


import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import org.springframework.stereotype.Service;

@Service
public interface CommunictionService {
    void printObject(Object query);
    ResultModel<TaskResult>  responseTaskResult(String msg);//result
    ResultModel<TaskResult>  responseTaskResult(String msg,Long intentId,String ... parameterNames);//ask_inf
}
