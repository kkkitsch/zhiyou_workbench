package com.zhiyou.mybatis.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyou.mybatis.bean.People;
import com.zhiyou.mybatis.dao.PeopleMapper;
import com.zhiyou.mybatis.util.MybatisUtils;

public class TestDynamicSQL {
	private static SqlSessionFactory factory;
	// 加载日志配置文件
	static Logger logger = null;

	static {
		// 获得实例
		factory = MybatisUtils.getSessionFactory();
		// 使用slf4j打印日志
		logger = LoggerFactory.getLogger(TestDynamicSQL.class);
	}

	@Test
	public void selectPeopleById() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);
			People people = mapper.selectPeopleById(5);
			if (people != null) {
				logger.info("查询成功");
				logger.info(people.toString());
			}
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test1() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);
			List<People> peoples = mapper.selectActivePeopleByInfo("%is%");
			if (peoples != null) {
				logger.info("查询成功");
				for (People people : peoples) {
					logger.info(people.toString());
				}
			}
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test2() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", 1);
			map.put("info", "%is%");
			List<People> peoples = mapper.selectByMap1(map);
			if (peoples != null) {
				logger.info("查询成功");
				for (People people : peoples) {
					logger.info(people.toString());
				}
			}
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test3() {

		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", 1);
			map.put("info", "%刻奇%");
			map.put("age", 10);
			map.put("sex", "m");
			List<People> peoples = mapper.selectByMap2(map);
			if (peoples != null) {
				logger.info("查询成功");
				for (People people : peoples) {
					logger.info(people.toString());
				}
			}
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test4() {

		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", 1);
			map.put("info", "%is%");
			List<People> peoples = mapper.trimByMap(map);
			if (peoples != null) {
				logger.info("查询成功");
				for (People people : peoples) {
					logger.info(people.toString());
				}
			}
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test5() {

		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);
			People people = new People();
			people.setName("%i%");
			people.setInfo("%i%");
			List<People> peoples = mapper.trimByPeople(people);
			if (peoples != null) {
				logger.info("查询成功");
				for (People people2 : peoples) {
					logger.info(people2.toString());
				}
			}
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test6() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);

			// 先获取一个people的数据，进行修改
			People people = mapper.selectPeopleById(5);
			people.setAge(321L);
			// 插入中文值乱码
			people.setName("胡斐");

			// 更改并提交
			int num = mapper.updatePeople(people);
			session.commit();
			if (num > 0) {
				logger.info("更新成功");
			}
		} catch (Exception e) {
			logger.info("更新失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test7() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);
			int num = mapper.deletePeopleById(24);
			session.commit();
			if (num > 0) {
				logger.info("删除成功");
			}
		} catch (Exception e) {
			logger.info("删除失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

	@Test
	public void test8() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);

			List<Integer> ids = Arrays.asList(28, 29);

			int num = mapper.deletePeopleByList(ids);

			session.commit();
			
			if (num > 0) {
				logger.info("删除成功");
			}
		} catch (Exception e) {
			logger.info("删除失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}

}
