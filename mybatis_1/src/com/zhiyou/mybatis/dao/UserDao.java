package com.zhiyou.mybatis.dao;

import java.util.List;

import com.zhiyou.mybatis.bean.User;

public interface UserDao {

	User getUserById(int id) throws Exception;

	List<User> getAllUsers();

	void updateUser(User user);

	void deleteUser(User user);

	void insertUser(User user);

}
