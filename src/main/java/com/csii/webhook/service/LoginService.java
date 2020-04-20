package com.csii.webhook.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public interface LoginService{
    public String login(String login, String password, String url, String state, Model model,String token);
        }

