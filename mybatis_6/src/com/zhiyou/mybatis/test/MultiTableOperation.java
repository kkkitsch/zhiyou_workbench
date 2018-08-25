package com.zhiyou.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyou.mybatis.bean.Clazz;
import com.zhiyou.mybatis.bean.Student;
import com.zhiyou.mybatis.dao.StudentMapper;
import com.zhiyou.mybatis.util.MybatisUtils;

public class MultiTableOperation {
	static SqlSessionFactory factory;
	// 加载日志配置文件
	static Logger logger = null;

	static {
		// 获得实例
		factory = MybatisUtils.getSessionFactory();
		// 使用slf4j打印日志
		logger = LoggerFactory.getLogger(MultiTableOperation.class);
	}

	@Test
	public void test1() {
		SqlSession session = factory.openSession();
		try {
			// 接口式编程：class com.sun.proxy.$Proxy5
			StudentMapper mapper = session.getMapper(StudentMapper.class);

			logger.info("接口式编程：" + mapper.getClass());

			Student student = mapper.getStudentById(1);

			if (student != null) {
				logger.info("查询成功");
				logger.info(student.toString());
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
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = mapper.getStudentWithClass(1);
			if (student != null) {
				logger.info("查询成功");
				logger.info(student.toString());
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
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = mapper.getStudentWithClass1(1);
			if (student != null) {
				logger.info("查询成功");
				logger.info(student.toString());
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
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Clazz clazz = mapper.getClazzById(154);
			if (clazz != null) {
				logger.info("查询成功");
				logger.info(clazz.toString());
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
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Clazz clazz = mapper.getClazzById1(152);
			if (clazz != null) {
				logger.info("查询成功");
				logger.info(clazz.toString());
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
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			List<Student> students = mapper.getStudentByClazzId(154);
			if (students != null) {
				logger.info("查询成功");
				for (Student student : students) {
					logger.info(student.toString());
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
	public void test7() {
		SqlSession session = factory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = mapper.getStudentClazzByStep(1);
			if (student != null) {
				logger.info("查询成功，学生姓名为:" + student.getStudent_name());
				// logger.info("学生班级信息为:" + student.getClazz());
			}
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		} finally {
			MybatisUtils.close(session);
		}
	}
}