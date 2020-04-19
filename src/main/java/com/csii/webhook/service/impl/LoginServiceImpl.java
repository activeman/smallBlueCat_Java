package com.csii.webhook.service.impl;

import com.csii.webhook.dao.userdao;
import com.csii.webhook.model.pojo.Users;
import com.csii.webhook.service.AuthService;
import com.csii.webhook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class LoginServiceImpl implements LoginService {

        @Autowired
        private AuthService authService;
        private userdao dao;
        @RequestMapping("/login")
        public String login(String login, String password, String url, String state, Model model)  {
            Users user = dao.userdao();
            if (login.equals(user.getLogin()) && password.equals(user.getPassword()) ){
                String token = authService.sign("csii");
                String newUrl = url + "&code=" + token + "&state=" + state;
                return "redirect:" + newUrl;
            }else{
                model.addAttribute("url",url);
                model.addAttribute("state",state);
                return "login";
            }

        }
    }
