package com.zhiyou.opera;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.Customer;
import com.zhiyou.util.DBConnPoolUtil;

public class GetCurrentSession {
	Session session;
	Transaction tr;

	// 执行单元测试之前进行的操作
	@Before
	public void init() {

		// 获取绑定到线程的Session
		session = DBConnPoolUtil.getCurrentSession();

		// 开始事务
		tr = session.beginTransaction();
	}

	@Test
	public void testCurrentSession() {
		System.out.println(session.get(Customer.class, 39L));
	}

	// 执行单元测试之后进行的操作
	@After
	public void after() {

		try {
			// 提交事务
			tr.commit();
			System.out.println("事务提交成功");
		} catch (Exception e) {
			System.out.println("事务提交失败");
			// 回滚事务
			tr.rollback();
			e.printStackTrace();
		}

		// 关闭连接
		DBConnPoolUtil.close(session);
	}
}
