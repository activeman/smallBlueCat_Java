package com.csii.webhook.service;


import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

public interface CommunictionService {
    void printObject(Object query);
    ResultModel<TaskResult>  responseTaskResult(String msg, ResultType resultType);
}
