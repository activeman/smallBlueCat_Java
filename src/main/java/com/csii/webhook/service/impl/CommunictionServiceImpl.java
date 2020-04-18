package com.csii.webhook.service.impl;

import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.fastjson.JSONArray;
import com.csii.webhook.service.CommunictionService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommunictionServiceImpl implements CommunictionService {
    @Override
    public void printQuery(TaskQuery query) {
        Object obj = JSONArray.toJSON(query);
        String json = obj.toString();
        System.out.println(toPrettyFormat(json));
    }

    @Override
    public ResultModel<TaskResult> responseTaskResult(String msg, ResultType resultType) {
        /**
         * 构建服务返回结果
         */
        ResultModel<TaskResult> resultModel = new ResultModel<TaskResult>();
        try {
            //回复语句携带的额外信息，map形式
            Map<String, String> extraMessages = new HashMap<>(16);
            extraMessages.put("额外信息", "manual extral message");
            //意图理解后的执行结果对象
            TaskResult result = new TaskResult();
            // result.setReply("回复的播报语句");
//            setResultType.setResultType();
            result.setReply(msg);
            result.setResultType(resultType);
            result.setProperties(extraMessages);
            result.setAskedInfos(new ArrayList()); //追问参数名，list形式
            result.setActions(new ArrayList()); //播控类音频信息，list形式
            result.setExecuteCode(ExecuteCode.SUCCESS);
            //返回对象
            resultModel.setReturnCode("0");
            resultModel.setReturnErrorSolution("出错时的描述信息");
            resultModel.setReturnMessage("执行成功的描述信息");
            resultModel.setReturnValue(result);
        } catch (Exception e) {
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        System.out.println(resultModel);
        return resultModel;
    }


//    json格式化
    private static String toPrettyFormat(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonObject);
    }

}
