package com.csii.webhook.controller;

import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.da.coin.ide.spi.trans.MetaFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 571002868
 */
@Controller
public class RequestController {

    /**
     * /financial开发者提供的技能执行路径地址，请求方式为POST请求
     */
    @RequestMapping(value = "/helloxx", method = RequestMethod.POST)//应用时用
    // @RequestMapping("/helloxxxx")//浏览器测试用
    @ResponseBody//结果转json用
    public  ResultModel<TaskResult> getResponse(@RequestBody String taskQuery) {
        /**
         * 将开发者平台识别到的语义理解的结果（json字符串格式）转换成TaskQuery
         */
        TaskQuery query = MetaFormat.parseToQuery(taskQuery);
        System.out.println();
        System.out.println(query);
        System.out.println();
        /**
         * 构建服务返回结果
         */
        ResultModel<TaskResult> resultModel = new ResultModel<TaskResult>();
        try {
            //回复语句携带的额外信息，map形式
            Map<String, String> extraMessages = new HashMap<>(16);
            extraMessages.put("额外信息", "manual extral message");
            //追问参数名，list形式
            List askInfo = new ArrayList();
            //播控类音频信息，list形式
            List actions = new ArrayList();
            //意图理解后的执行结果对象
            TaskResult result = new TaskResult();
            // result.setReply("回复的播报语句");
            result.setReply(query.getUtterance());
            result.setResultType(ResultType.RESULT);
            // result.setResultType(ResultType.ASK_INF);
            result.setProperties(extraMessages);
            result.setAskedInfos(askInfo);
            result.setActions(actions);
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

    @RequestMapping("/c")
    @ResponseBody
    public Map<String, Object> consent(String code) {
        System.out.println("---consent---");
        System.out.println();
        System.out.println(code);
        System.out.println();
        Map<String, Object> map = new HashMap<>();
        map.put("access_token", code);
        map.put("refresh_token", "refresh123456789");
        map.put("expires_in", 17600000);
        return map;
    }

}



// 天气服务执行，根据NLU理解的结果做相应处理并返回回复语句
/*@Component
class WeatherHandleImpl implements WeatherHandle {

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
        //logger.info("WeatherHandleImpl execute...");

        //从请求中获取意图参数以及参数值
       // Map<String, String> paramMap = taskQuery.getSlotEntities().stream().collect(Collectors.toMap(slotItem -> slotItem.getIntentParameterName(), slotItem -> slotItem.getStandardValue()));
       // logger.info("paramMap ：" + paramMap.toString());
        //如果意图是询问空气质量，则执行空气质量逻辑
        if (taskQuery.getIntentName().equals("空气质量")) {
            return aqiQuery(taskQuery, paramMap);
            //如果意图是询问天气情况，则执行天气查询逻辑
        } else if (taskQuery.getIntentName().equals("天气查询")) {
            return baseQuery(taskQuery, paramMap);
        } else {
            return null;
        }
        return null;
    }

        private TaskResult baseQuery(TaskQuery taskQuery, Map<String, String> paramMap) {
        TaskResult result = new TaskResult();
        try {
            //请求服务并填充回复语句
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("areaName", paramMap.get("city")));
            params.add(new BasicNameValuePair("date", DateUtil.getStartDate(paramMap.get("time"))));
            String executeBody = httpGet(params);
            String weather = getWeather(executeBody);
            Map<String, String> properties = new HashMap<String, String>();

            properties.put("city", paramMap.get("city"));
            properties.put("time", paramMap.get("time"));
            properties.put("weather", weather);
            properties.put("temp_low", getTempLow(executeBody));
            properties.put("temp_high", getTempHigh(executeBody));
            properties.put("wind_direct", getWindDirect(executeBody));
            properties.put("power", getPower(executeBody));
            if (weather == null) {
                result.setReply("对不起，我现在只支持查询最近4天的天气");
            } else {
                result.setReply(TemplateFillUtil
                        .fillTemplate(
                                "@{city} @{time}天气 @{weather}，温度@{temp_low}到@{temp_high}度，@{wind_direct}@{power}",
                                properties));
            }

            result.setExecuteCode(ExecuteCode.SUCCESS);
            result.setResultType(ResultType.RESULT);
        } catch (Exception e) {
            logger.info("query exception", e);
            result.setExecuteCode(ExecuteCode.EXECUTE_ERROR);
        }

        return result;
    }
}*/


