package com.zhiyou.mybatis.test;

import java.util.List;

import org.junit.Test;

import com.zhiyou.mybatis.bean.User;
import com.zhiyou.mybatis.dao.UserDao;
import com.zhiyou.mybatis.imp.UserDaoImp;

public class UserCRUD {

	@Test
	public void testGetUser() throws Exception {
		UserDao userDao = new UserDaoImp();
		User user = userDao.getUserById(7);
		System.out.println(user);
	}

	@Test
	public void testGetAllUser() throws Exception {
		UserDao userDao = new UserDaoImp();
		List<User> users = userDao.getAllUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testUpdate() throws Exception {
		UserDao userDao = new UserDaoImp();
		User user = userDao.getUserById(7);
		user.setPassword("newPassword");
		userDao.updateUser(user);
	}

	@Test
	public void testDelete() throws Exception {
		UserDao userDao = new UserDaoImp();
		User user = userDao.getUserById(7);
		user.setPassword("newPassword");
		userDao.deleteUser(user);
	}

	@Test
	public void testInsert() throws Exception {
		UserDao userDao = new UserDaoImp();
		User user = userDao.getUserById(8);
		userDao.insertUser(user);
	}

}
