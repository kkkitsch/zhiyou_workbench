package com.zhiyou.mybatis.dao;

import java.util.List;

import com.zhiyou.mybatis.bean.User;

public interface UserMapper {

	User getUserById(int id);

	List<User> getAllUsers();

	int updateUser(User user);

	int deleteUser(User user);

	int insertUser(User user);

}
