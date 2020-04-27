package com.csii.webhook.controller;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;


import com.csii.webhook.model.pojo.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

import com.csii.webhook.model.pojo.BusinessQuery;
import com.csii.webhook.model.pojo.MetaFormat;
import com.csii.webhook.model.pojo.SlotEntity;
import com.csii.webhook.service.CommunictionService;
import com.csii.webhook.service.TestService;
import com.csii.webhook.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 571002868
 */
@Controller
@ResponseBody
public class BohaiController {
    private Logger logger = LoggerFactory.getLogger(BohaiController.class);
    @Autowired
    UsersService usersService;
    @Autowired
    CommunictionService communictionService;
    @Autowired
    TestService testService;
    /**
     * Test
     */
    @RequestMapping(value = "/helloxx.do", method = RequestMethod.POST)
    public ResultModel<TaskResult> getResponse(@RequestBody String taskQuery) {
        //将开发者平台识别到的语义理解的结果（json字符串格式）转换成TaskQuery
        TaskQuery query = MetaFormat.parseToQuery(taskQuery);
        //打印一下
        communictionService.printObject(query);
        // 构建服务返回结果
        // return communictionService.responseTaskResult("请输入一句话",query.getIntentId(),"a","b");//ASK_INF
        return communictionService.responseTaskResult("请输入一句话");//RESULT
    }

    @RequestMapping("/c.do")
    public Map<String, Object> consent(String code) {
        System.out.println("---consent---");
        System.out.println("code:\t"+code);
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }

    /**
     * 存款产品
     */
    @RequestMapping(value = "/deposit.do", method = RequestMethod.POST)
    public ResultModel<TaskResult> depositController(@RequestBody String taskQuery) {

        //进入前判断token 和openid信息，到这里已经确认没问题了

        // 解析请求获取 TaskQuery
        TaskQuery query = MetaFormat.parseToQuery(taskQuery);

        // 打印一下query，观察分析数据
        communictionService.printObject(query);

        //向redis里存意图标签。key：openid:token:"intent" , value: "deposit"
        BusinessQuery businessQuery = null;
//        businessQuery.setId(query.getSessionId());
        businessQuery.setToken(query.getToken());
        businessQuery.setSessionId(query.getSessionId());
        businessQuery.setUtterance(query.getUtterance());
        businessQuery.setDeviceOpenId(query.getUtterance());
//        根据SlotEntities IntentParameterName为key
        //  Map<String, SlotEntity> map =query.getSlotEntities().stream().collect(Collectors.toMap(SlotEntity::getIntentParameterName, Function.identity(), (key1, key2) -> key2));
        Map<String,SlotEntity> map = new HashMap<>();
        List<SlotEntity> list = query.getSlotEntities();
        for (SlotEntity key: list) {
            map.put(key.getIntentParameterName(),key);
        }
        businessQuery.setSlotEntities(map);
//        private String Id, Token, SessionId, Utterance, DeviceOpenId;//全部继承TaskQuery信息//每一次请求都要验证token
//        private String BusinessIntent;//业务意图，非TaskQuery意图
//        private Map<String, SlotEntity> SlotEntities;//从TaskQuery信息处理后的得到

//        testService.saveBusinessQuery()
        // 调用depositService方法，传入taskQuery，return TaskResult
//        bohaiService.depositService(query);
        // 以下全在 depositService中处理

        //从redis里取出BusinessQueryString

        //判断BusinessQueryString是否为null，为null：new 一个新的 BusinessQuery 对象。
        // 不为null：BusinessQueryString转为BusinessQuery对象

        //TaskQuery的 Token, SessionId, Utterance, DeviceOpenId，直接赋值给BusinessQuery

        // SlotEntities：在TaskQuery.SlotEntities里做判断， LiveTime为0的，
        // 赋值给BusinessQuery.SlotEntities，并且以 intentParameterName 的值为可以

        //最重要，也是最复杂的：根据TaskQuery判断出BusinessQuery.BusinessIntent意图，赋值
        //     可能需要：根据查到的BusinessQuery.BusinessIntent基础上，判断新意图，继续拼接，
        //      根据SlotEntities的参数是否完整，判断新意图，继续拼接，
        //      需要继续分析完善，核心步骤

        // 完善以后的BusinessQuery对象重新存到redis里

        // 根据IntentQA获得播放的答案，需要一个槽位替换参数的方法，修改播放答案模板

        //根据BusinessQuery.BusinessIntent，选择响应的resultType是RESULT或ASK_INF

        //如果是ASK_INF，还要根据BusinessIntent判断携带参数的问题

        //在Service里 return TaskResult 方法结束

        // return最后的结果
        return communictionService.responseTaskResult("请输入一句话");
    }

    /**
     * 兜底fallback
     */
    @RequestMapping(value = "/fallback.do", method = RequestMethod.POST)
    public ResultModel<TaskResult> fallbackController(@RequestBody String taskQuery) {
        //进入前判断token 和openid信息，到这里已经确认没问题了

        // 解析请求获取 TaskQuery
        TaskQuery query = MetaFormat.parseToQuery(taskQuery);

        // 打印一下query，观察分析数据
        communictionService.printObject(query);
        //把这个com.alibaba.da.coin.ide.spi.standard.TaskQuery 转为com.csii.webhook.model.pojo.TaskQuery 然后存到mysql里，留做日后分析使用

        //从redis里取意图标签。key：openid:token:"intent" , 结果可能是 deposit，可能是fund 可能是 other

        // 使用switch case 走分支，调用各种意图的Service方法，传入taskQuery，return TaskResult

        // 在Service处理完后得到 TaskResult

        // return最后的结果
        return null;
    }
}


