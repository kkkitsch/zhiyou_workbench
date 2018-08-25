package com.zhiyou.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.zhiyou.mybatis.bean.User;

public interface UserMapper {

	User getUserById(int id);

	User getUserById1(int id);

	User getUserById2(String id);

	Map<String, Object> getUserReturnMap(int id);

	@MapKey("id")
	Map<Integer, User> getUserByLikeReturnMap(String name);

	List<User> getAllUsers();

	List<User> getUserByPage(@Param(value = "startPage") int start, @Param(value = "endPage") int end);

	List<User> getUserByPage1(int startPage, int endPage);

	List<User> getUserByPage2(Map<String, Object> map);

	List<User> getUserByLike(Map<String, Object> map);

	int insertUser(User user);

	int insertUser1(User user);

	int deleteUser(int id);

	int updateUser(Map<String, Object> map);

}
