package com.csii.webhook.service.impl;

import com.csii.webhook.dao.FindUsersDao;
import com.csii.webhook.model.pojo.Users;
import com.csii.webhook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private FindUsersDao findUsers;

    @Override
    public Boolean login(String login, String password) {

        Users user = findUsers.findUsers(login, password);

        int id = 0;
        try {
            id = user.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id == 0) {
            System.out.println("查询失败");
            return false;
        } else {
            System.out.println("查询成功");
            return true;
        }

    }
}

