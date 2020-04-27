package com.csii.webhook.service;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liushuai on 2020/4/24.
 */
@Service
public interface BohaiService {
    ResultModel<TaskResult> depositService(TaskQuery query);
    ResultModel<TaskResult> fundService(TaskQuery query);
}
