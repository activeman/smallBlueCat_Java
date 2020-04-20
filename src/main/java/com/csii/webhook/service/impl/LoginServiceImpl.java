package com.csii.webhook.service.impl;

import com.csii.webhook.dao.FindUsersDao;
import com.csii.webhook.model.pojo.Users;
import com.csii.webhook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private FindUsersDao findUsers;
    @RequestMapping("/login")
    public boolean login(String login, String password)  {
        Users user = findUsers.findUsers();
        //将 传入的login password 与数据库中的 作对比，匹配则登录成功
        if (login.equals(user.getLogin()) && password.equals(user.getPassword()) ){
            return true;
        }else{
            return false;
        }
    }


    //    地址拼接
    public String urlSplicing(boolean t,String url, String state,String token, Model model)  {
        if (t==true){
            String newUrl = url + "&code=" + token + "&state=" + state;
            return newUrl;
        }else{
            model.addAttribute("url",url);
            model.addAttribute("state",state);
            return "login";
        }
    }
}
