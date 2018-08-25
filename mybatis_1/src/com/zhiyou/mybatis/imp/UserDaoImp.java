package com.zhiyou.mybatis.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyou.mybatis.bean.User;
import com.zhiyou.mybatis.dao.UserDao;
import com.zhiyou.mybatis.util.MybatisUtils;

public class UserDaoImp implements UserDao {

	private static SqlSessionFactory factory;
	// 加载日志配置文件
	static Logger logger = null;

	static {
		// 获得实例
		factory = MybatisUtils.getSessionFactory();
		// 使用slf4j打印日志
		logger = LoggerFactory.getLogger(UserDaoImp.class);
	}

	public User getUserById(int id) {
		SqlSession session = factory.openSession();
		try {
			User user = session.selectOne("User.getUserById", id);
			logger.info("查询成功");
			return user;
		} catch (Exception e) {
			logger.info("查询失败");
			return null;
		} finally {
			MybatisUtils.close(session);
		}
	}

	public List<User> getAllUsers() {
		SqlSession session = factory.openSession();
		try {
			List<User> users = session.selectList("User.getAllUsers");
			logger.info("查询成功");
			return users;
		} catch (Exception e) {
			logger.info("查询失败");
			return null;
		} finally {
			MybatisUtils.close(session);
		}
	}

	public void updateUser(User user) {
		SqlSession session = factory.openSession();
		try {
			int update = session.update("User.updateUser", user);
			session.commit();
			if (update > 0) {
				logger.info("更新成功");
			}
		} catch (Exception e) {
			logger.info("更新失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	public void deleteUser(User user) {
		SqlSession session = factory.openSession();
		try {
			int delete = session.delete("User.deleteUser", user);
			session.commit();
			if (delete > 0) {
				logger.info("删除成功");
			}
		} catch (Exception e) {
			logger.info("删除失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	public void insertUser(User user) {
		SqlSession session = factory.openSession();
		try {
			int insert = session.insert("User.insertUser", user);
			session.commit();
			if (insert > 0) {
				logger.info("添加成功");
			}
		} catch (Exception e) {
			logger.info("添加失败");
		} finally {
			MybatisUtils.close(session);
		}
	}
}
