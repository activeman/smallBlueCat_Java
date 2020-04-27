package com.csii.webhook.service.impl;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.csii.webhook.service.BohaiService;
import org.springframework.stereotype.Service;

/**
 * Created by liushuai on 2020/4/24.
 */
@Service
public class BohaiServiceImpl implements BohaiService {
    @Override
    public ResultModel<TaskResult> depositService(TaskQuery query) {
        return null;
    }

    @Override
    public ResultModel<TaskResult> fundService(TaskQuery query) {
        return null;
    }
}
