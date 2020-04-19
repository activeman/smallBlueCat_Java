package com.csii.webhook.service;


import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

public interface CommunictionService {
    void printQuery(TaskQuery query);
    ResultModel<TaskResult>  responseTaskResult(String msg, ResultType resultType);
}
