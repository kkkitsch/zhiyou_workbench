package com.zhiyou.lazy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.Customer;
import com.zhiyou.util.DBConnPoolUtil;
import com.zhiyou.util.LazyLoader;

public class TestLazy {

	Session session;
	Transaction tr;

	// 执行单元测试之前进行的操作
	@Before
	public void init() {

		// 从连接池中获取一个连接
		session = LazyLoader.getConnection();

		// 开始事务
		tr = session.beginTransaction();
	}

	// 测试类级别的延迟加载
	@Test
	public void testLazy() {

		// 断点调试
		Customer customer = session.load(Customer.class, 60L);
		System.out.println(customer.getCust_id());

		System.out.println("------------------------");

		System.out.println(customer.getCust_name());

	}

	// 测试不使用延迟加载
	@Test
	public void testGet() {

		// 断点调试
		Customer customer = session.get(Customer.class, 60L);
		System.out.println(customer.getCust_id());

		System.out.println("------------------------");

		System.out.println(customer.getCust_name());

	}

	// 关联级别的延迟加载，当需要linkman中的数据时，才发送
	@Test
	public void testGet1() {

		// 断点调试
		Customer customer = session.get(Customer.class, 60L);
		System.out.println(customer.getCust_id());

		System.out.println("------------------------");

		System.out.println(customer.getLinkMans().size());
	}

	// 配置fetch="subselect" lazy="true"查询输出
	@Test
	public void testSubselect() {
		Query<?> query = session.createQuery("from Customer");
		List<Customer> customers = (List<Customer>) query.list();
		for (Customer customer : customers) {
			System.out.println(customer.getLinkMans().size());
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