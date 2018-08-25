package com.zhiyou.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void testGetUserById1() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById1(1);
			logger.info("查询成功,获取的数据为：{}", user);
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testGetUserById2() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById2("1");
			logger.info("查询成功,获取的数据为：{}", user);
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testGetUserById3() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<String, Object> user = mapper.getUserReturnMap(1);
			if (user != null) {
				logger.info("查询成功,获取的数据为：{}", user);
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test6() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<Integer, User> user = mapper.getUserByLikeReturnMap("%k%");
			if (user != null) {
				logger.info("查询成功lalalalala,获取的数据为：{}", user);
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testGetAllUsers() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = mapper.getAllUsers();
			logger.info("查询成功");
			for (User user : users) {
				logger.info(user.toString());
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testGetUserByLike() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "%张%");
			List<User> users = mapper.getUserByLike(map);
			logger.info("查询成功");
			for (User user : users) {
				logger.info(user.toString());
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testInsertUser() {
		SqlSession session = factory.openSession();
		try {
			User user = new User("kkk", "ppp", 21);
			UserMapper mapper = session.getMapper(UserMapper.class);
			int num = mapper.insertUser(user);
			session.commit();
			if (num > 0) {
				logger.info("插入成功,获取自增id：{}", user.getId());
			}
		} catch (Exception e) {
			logger.info("插入失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testInsertUserAutoCommit() {

		// 设置为true，为自动提交
		SqlSession session = factory.openSession(true);

		try {
			User user = new User("kkk", "ppp", 21);
			UserMapper mapper = session.getMapper(UserMapper.class);
			int num = mapper.insertUser(user);

			// 设置了自动提交，无需手动提交
			// session.commit();
			if (num > 0) {
				logger.info("插入成功,获取自增id：{}", user.getId());
			}
		} catch (Exception e) {
			logger.info("插入失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testInsert1() {
		SqlSession session = factory.openSession();
		try {
			User user = new User("kkk", "ppp", 21);
			UserMapper mapper = session.getMapper(UserMapper.class);
			int num = mapper.insertUser1(user);
			session.commit();
			if (num > 0) {
				logger.info("插入成功,获取自增id：{}", user.getId());
			}
		} catch (Exception e) {
			logger.info("插入失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testDeleteUser() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int num = mapper.deleteUser(3);
			session.commit();
			if (num > 0) {
				logger.info("删除成功");
			}
		} catch (Exception e) {
			logger.info("删除成功");
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void testUpdateUser() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(3);
			user.setPassword("kkkitsch1996");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", user);
			int num = mapper.updateUser(map);
			session.commit();
			if (num > 0) {
				logger.info("更新成功");
			}
		} catch (Exception e) {
			logger.info("更新失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	// 测试使用内置参数

	/*
	 * 分页查询传参方式一
	 */
	@Test
	public void testGetUserByPage() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = mapper.getUserByPage(2, 2);
			logger.info("查询成功");
			for (User user : users) {
				logger.info(user.toString());
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	/*
	 * 分页查询传参方式二，传入多个参数
	 */
	@Test
	public void testGetUserByPage1() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = mapper.getUserByPage1(2, 2);
			logger.info("查询成功");
			for (User user : users) {
				logger.info(user.toString());
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	/*
	 * 分页查询传参方式三
	 */
	@Test
	public void testGetUserByPage2() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startPage", 2);
			map.put("endPage", 3);
			List<User> users = mapper.getUserByPage2(map);
			logger.info("查询成功");
			for (User user : users) {
				logger.info(user.toString());
			}
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}
}