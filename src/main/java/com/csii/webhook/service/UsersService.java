package com.csii.webhook.service;




import com.csii.webhook.pojo.JwtUser;
import com.csii.webhook.pojo.Users;

import java.util.List;

public interface UsersService {

	void addUser(Users users);
	List<Users> findUserAll();
	Users findUserById(Integer id);
	void updateUser(Users users);
	void deleteUserById(Integer id);


	/**
	 * 校验用户信息
	 * @param loginName
	 * @param passWord
	 * @return
	 */
	boolean checkUser(String loginName, String passWord);

	/**
	 * 查询用户信息
	 * @param loginName
	 * @return
	 */
	JwtUser getUser(String loginName);
}



