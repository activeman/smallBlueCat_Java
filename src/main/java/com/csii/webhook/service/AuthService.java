package com.csii.webhook.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    public String sign(String username);
}
