package com.csii.webhook.service;


import com.csii.webhook.model.pojo.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

	void addUser(Users users);

}



