package com.zhiyou.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyou.mybatis.bean.User;
import com.zhiyou.mybatis.dao.UserMapper;
import com.zhiyou.mybatis.util.MybatisUtils;

public class UserCRUD {
	private static SqlSessionFactory factory;
	// 加载日志配置文件
	static Logger logger = null;

	static {
		// 获得实例
		factory = MybatisUtils.getSessionFactory();
		// 使用slf4j打印日志
		logger = LoggerFactory.getLogger(UserCRUD.class);
	}

	@Test
	public void testGetUserById() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user);
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testGetAllUser() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = mapper.getAllUsers();
			logger.info("查询成功");
			for (User user : users) {
				System.out.println(user);
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testInsert() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);
			int num = mapper.insertUser(user);
			session.commit();
			if (num > 0) {
				logger.info("插入数据成功");
			}
		} catch (Exception e) {
			logger.info("插入数据失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testDelete() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(2);
			int num = mapper.deleteUser(user);
			session.commit();
			if (num > 0) {
				logger.info("删除数据成功");
			}
		} catch (Exception e) {
			logger.info("删除数据失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testUpdate() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(2);
			user.setPassword("ttttttt");
			int num = mapper.updateUser(user);
			session.commit();
			if (num > 0) {
				logger.info("更新数据成功");
			}
		} catch (Exception e) {
			logger.info("更新数据失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

}