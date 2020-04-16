package com.csii.webhook.controller;

import com.alibaba.fastjson.JSONObject;
import com.csii.webhook.pojo.JwtUser;
import com.csii.webhook.service.AjaxResult;
import com.csii.webhook.service.UsersService;
import com.csii.webhook.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liushuai on 2020/1/19.
 */

@Controller
@RequestMapping
//@Slf4j
public class JwtController {


    @Autowired
    private UsersService userService;


    @RequestMapping("loginx")
    @ResponseBody
    public AjaxResult login(@RequestBody Map<String, String> map) {
        System.out.println("login.....");
        String loginName = map.get("loginName");
        String passWord = map.get("passWord");
        //身份验证
        boolean isSuccess = userService.checkUser(loginName, passWord);
        if (isSuccess) {
            //模拟数据库查询
            JwtUser user = userService.getUser(loginName);
            if (user != null) {
                //返回token
                String token = JwtUtil.sign(loginName, passWord);
                if (token != null) {
                    System.out.println();
                    System.out.println(token);
                    System.out.println();
                    return AjaxResult.success("成功", token);
                }
            }
        }
        return AjaxResult.fail();
    }

    @RequestMapping("getUserx")
    @ResponseBody
    public AjaxResult getUserInfo(HttpServletRequest request, @RequestBody Map<String, String> map) {
        System.out.println("getUserInfo.....");
        String loginName = map.get("loginName");
        String token = request.getHeader("token");
        System.out.println();
        System.out.println(token);
        System.out.println();
        boolean verity = JwtUtil.verity(token);
        if (verity) {
            JwtUser user = userService.getUser(loginName);
            if (user != null) {
                return AjaxResult.success("成功", JSONObject.toJSONString(user));
            }
        }
        return AjaxResult.fail();
    }
}

