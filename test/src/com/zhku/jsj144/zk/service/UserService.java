package com.zhku.jsj144.zk.service;

import java.sql.SQLException;

import com.zhku.jsj144.zk.dao.UserDao;
import com.zhku.jsj144.zk.domain.User;

//业务层
public class UserService {

	UserDao userDao=new UserDao();
	
	public User login(User user) throws ClassNotFoundException, SQLException{
		User result=userDao.login(user);
		return result;
	}
}
