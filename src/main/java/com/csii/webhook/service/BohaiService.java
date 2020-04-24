package com.csii.webhook.service;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

/**
 * Created by liushuai on 2020/4/24.
 */
public interface BohaiService {
    ResultModel<TaskResult> depositService(TaskQuery query);
    ResultModel<TaskResult> fundService(TaskQuery query);
}
