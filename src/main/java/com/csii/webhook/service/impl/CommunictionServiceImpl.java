package com.csii.webhook.service.impl;

import com.alibaba.da.coin.ide.spi.meta.AskedInfoMsg;
import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.fastjson.JSONObject;
import com.csii.webhook.service.CommunictionService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CommunictionServiceImpl implements CommunictionService {
    @Override
    public void printObject(Object query) {

        String json = JSONObject.toJSONString(query);
        System.out.println(toPrettyFormat(json));
    }

  //一个参考，不再使用
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


            // 改造一下go的response 数据，测试，这里传递的ask参数，要分析处理下，
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

    /**
     * 响应RESULT状态
     * 参数说明文档：https://www.aligenie.com/doc/357834/fqzdmv
     */
    @Override
    public ResultModel<TaskResult> responseTaskResult(String msg) {
        ResultModel<TaskResult> resultModel = new ResultModel<TaskResult>();
        try {
            //返回对象
            resultModel.setReturnCode("0");
            //意图理解后的执行结果对象
            TaskResult result = new TaskResult();
            result.setReply(msg);
            result.setResultType(ResultType.RESULT);
            result.setExecuteCode(ExecuteCode.SUCCESS);
            resultModel.setReturnValue(result);
        } catch (Exception e) {
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        return resultModel;
    }

    /**
     * 响应ASK_INF状态
     */
    @Override
    public ResultModel<TaskResult> responseTaskResult(String msg, Long intentId, String... parameterNames) {
        ResultModel<TaskResult> resultModel = new ResultModel<TaskResult>();
        try {
            //返回对象
            resultModel.setReturnCode("0");
            //意图理解后的执行结果对象
            TaskResult result = new TaskResult();
            result.setReply(msg);
            result.setResultType(ResultType.ASK_INF);

            List<AskedInfoMsg> askedInfos = new ArrayList<>();
            for (int i = 0; i < parameterNames.length; i++) {
                askedInfos.add(new AskedInfoMsg(parameterNames[i], intentId));
            }
            result.setAskedInfos(askedInfos);

            result.setExecuteCode(ExecuteCode.SUCCESS);
            resultModel.setReturnValue(result);
        } catch (Exception e) {
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }
        return resultModel;
    }


    //json格式化
    private static String toPrettyFormat(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonObject);
    }

}
