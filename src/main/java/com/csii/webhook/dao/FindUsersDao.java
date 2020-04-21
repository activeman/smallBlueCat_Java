package com.csii.webhook.dao;


import com.csii.webhook.model.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface FindUsersDao {
    Users findUsers(String login,String password);
}
