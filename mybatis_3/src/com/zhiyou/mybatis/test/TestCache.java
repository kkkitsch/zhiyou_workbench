package com.zhiyou.mybatis.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyou.mybatis.bean.User;
import com.zhiyou.mybatis.dao.UserMapper;
import com.zhiyou.mybatis.util.MybatisUtils;

public class TestCache {
	private static SqlSessionFactory factory;
	// 加载日志配置文件
	static Logger logger = null;

	static {
		// 获得实例
		factory = MybatisUtils.getSessionFactory();
		// 使用slf4j打印日志
		logger = LoggerFactory.getLogger(UserCRUD.class);
	}

	// 测试一级缓存（不修改查询值），控制台只打印一次sql语句
	@Test
	public void testOneCache() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user);

			// 清除缓存
			session.clearCache();

			User user1 = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user1);

			logger.info("测试两次查询出的数据的引用是否相等:" + (user == user1));

		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	// 测试一级缓存（修改查询值进行提交），打印两条sql查询语句
	@Test
	public void testOneCache1() {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user);
			user.setPassword("kitschkkk");

			// 设定一个Map参数
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", user);
			mapper.updateUser(map);

			// 必须进行提交操作
			session.commit();

			// 再次进行查询
			logger.info("修改了查询值");
			User user1 = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user1);
		} catch (Exception e) {
			logger.info("查询失败");
		} finally {
			MybatisUtils.close(session);
		}
	}

	// 测试二级缓存（不修改查询值）
	@Test
	public void testTwoCache() {
		SqlSession session = factory.openSession();
		SqlSession session2 = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user);

			MybatisUtils.close(session);

			// 进行第二次查询
			mapper = session2.getMapper(UserMapper.class);
			User user2 = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user2);
			MybatisUtils.close(session2);
		} catch (Exception e) {
			logger.info("查询失败");
		}
	}

	// 测试二级缓存（修改查询值），此时会打印两条sql查询语句
	@Test
	public void testTwoCache1() {
		SqlSession session = factory.openSession();
		SqlSession session2 = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user);

			// 修改user属性
			user.setPassword("fjslfjsl");
			// 设定一个Map参数
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", user);
			mapper.updateUser(map);
			// 在close前，进行提交操作，如果在关闭session后进行提交操作，会报错
			session.commit();

			// 必须进行关闭session操作
			MybatisUtils.close(session);

			mapper = session2.getMapper(UserMapper.class);
			User user2 = mapper.getUserById(1);
			logger.info("查询成功,获取的数据为：{}", user2);
			MybatisUtils.close(session2);
		} catch (Exception e) {
			logger.info("查询失败");
		}
	}

}
