package com.csii.webhook.service.impl;


import com.csii.webhook.pojo.JwtUser;
import com.csii.webhook.pojo.Users;
import com.csii.webhook.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Override
    public void addUser(Users users) {
        System.out.println("addUser");
        System.out.println(users);
    }

    @Override
    public List<Users> findUserAll() {
        System.out.println("findUserAll");
        List<Users> lu = new ArrayList<>();
        lu.add(new Users(1, "a", 16));
        lu.add(new Users(2, "b", 17));
        lu.add(new Users(3, "c", 18));
        return lu;
    }

    @Override
    public Users findUserById(Integer id) {
        System.out.println("findUserById");
        Map<Integer, Users> mu = new HashMap<>();
        mu.put(1, new Users(1, "a", 16));
        mu.put(2, new Users(2, "b", 17));
        mu.put(3, new Users(3, "c", 18));
        return mu.get(id);
    }

    @Override
    public void updateUser(Users users) {
        System.out.println("updateUser");
        System.out.println(users);
    }

    @Override
    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById");
        System.out.println(id);
    }


    /**
     * @author: Milogenius
     * @create: 2019-07-08 11:21
     * @description:
     **/
    @Override
    public boolean checkUser(String loginName, String passWord) {
        return true;
    }

    @Override
    public JwtUser getUser(String loginName) {
        JwtUser user = new JwtUser();
        user.setName("李四");
        user.setPassword("123");
        return user;
    }
}
