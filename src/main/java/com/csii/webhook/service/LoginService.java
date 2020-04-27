package com.csii.webhook.service;

import org.springframework.stereotype.Service;


@Service
public interface LoginService{
    Boolean login(String login, String password);
}

