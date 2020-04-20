package com.csii.webhook.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public interface LoginService{
    boolean login(String login, String password);
    String urlSplicing(boolean t,String url, String state,String token, Model model);
}

