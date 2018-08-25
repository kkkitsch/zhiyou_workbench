package com.zhiyou.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyou.mybatis.bean.People;
import com.zhiyou.mybatis.bean.PeopleExample;
import com.zhiyou.mybatis.bean.PeopleExample.Criteria;
import com.zhiyou.mybatis.dao.PeopleMapper;
import com.zhiyou.mybatis.util.MybatisUtils;

public class TestGenerator {
	private static SqlSessionFactory factory;
	// 加载日志配置文件
	static Logger logger = null;

	static {
		// 获得实例
		factory = MybatisUtils.getSessionFactory();
		// 使用slf4j打印日志
		logger = LoggerFactory.getLogger(TestGenerator.class);
	}

	@Test
	public void test1() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);

			// 通过主键查询People
			People people = mapper.selectByPrimaryKey(5L);
			if (people != null) {
				logger.info("查询成功，" + people.toString());
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

			// 查询条件的形式为：（条件1&&条件2&&条件3），查询年龄在12到24，info中包含llh的，性别为m的people
			//select id, name, age, info, status, sex from people WHERE ( age between ? and ? and info like ? and sex like ? ) 
			PeopleExample example = new PeopleExample();
			Criteria criteria = example.createCriteria();
			criteria.andAgeBetween(12L, 24L);
			criteria.andInfoLike("%llh%");
			criteria.andSexLike("m");

			List<People> peoples = mapper.selectByExample(example);
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

			// 查询条件的形式为：（条件1&&条件2） 或 （条件3） ，查询年龄在12到24，info中包含llh的，性别为m的people
//			select id, name, age, info, status, sex from people WHERE ( age between ? and ? and info like ? ) or( sex = ? ) 
			PeopleExample example = new PeopleExample();

			Criteria criteria = example.createCriteria();
			criteria.andAgeBetween(12L, 24L);
			criteria.andInfoLike("%llh%");

			Criteria criteria2 = example.createCriteria();
			criteria2.andSexEqualTo("m");

			// 或的形式
			example.or(criteria2);

			List<People> peoples = mapper.selectByExample(example);
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

	
	
	// test3和test4的插入方法不一样，做比较
	// select id, name, age, info, status, sex from people WHERE ( age between ? and ? and info like ? ) or( sex = ? ) 
	@Test
	public void test3() {
		SqlSession session = factory.openSession();
		try {
			PeopleMapper mapper = session.getMapper(PeopleMapper.class);

			// 插入People
			People people = new People();
			people.setAge(21L);
			people.setInfo("today is starting linux!!!");
			people.setName("LLLINUX");

			int num = mapper.insertSelective(people);

			// 要提交
			session.commit();

			if (num > 0) {
				logger.info("插入成功");
			}

		} catch (Exception e) {
			logger.info("插入失败");
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

			// 插入People
			People people = new People();
			people.setName("CentOS");

			int num = mapper.insert(people);

			// 要提交
			session.commit();

			if (num > 0) {
				logger.info("插入成功");
			}
		} catch (Exception e) {
			logger.info("插入失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}
}
