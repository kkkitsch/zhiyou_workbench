package com.zhiyou.opera;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.Customer;
import com.zhiyou.util.DBConnPoolUtil;

/**
 * @author Administrator
 * @description 测试query by criteria
 */
public class TestQBC {

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
	public void test1() {

		// 创建criteria对象
		Criteria c = session.createCriteria(Customer.class);

		// 不带条件的查询
		List<Customer> customers = c.list();
		for (Object customer : customers) {
			System.out.println(customer);
		}
	}

	@Test
	public void test2() {
		// 创建criteria对象
		Criteria c = session.createCriteria(Customer.class);
		// 带条件的模糊查询
		c.add(Restrictions.like("cust_name", "%i%"));
		List<Customer> customers = c.list();
		for (Object customer : customers) {
			System.out.println(customer);
		}
	}

	@Test
	public void test3() {

		// 创建criteria对象
		Criteria c = session.createCriteria(Customer.class);
		// 第一个条件：模糊查询
		c.add(Restrictions.like("cust_name", "%i%"));
		// 第二个条件
		c.add(Restrictions.eq("cust_level", "2"));

		// 也可以把两个条件放到一起
		// c.add(Restrictions.or(Restrictions.like("cust_name", "%i%"),
		// Restrictions.eq("cust_level", "2")));

		List<Customer> customers = c.list();
		for (Object customer : customers) {
			System.out.println(customer);
		}
	}

	@Test
	public void test4() {

		// 创建criteria对象
		Criteria c = session.createCriteria(Customer.class);
		// 分页查询
		c.setFirstResult(2);
		c.setMaxResults(3);
		// 不带条件的查询
		List<Customer> customers = c.list();
		for (Object customer : customers) {
			System.out.println(customer);
		}
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
