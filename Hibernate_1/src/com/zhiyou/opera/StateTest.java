package com.zhiyou.opera;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.Customer;
import com.zhiyou.util.DBConnPoolUtil;

/**
 * @author Administrator
 * @description 测试持久化对象的状态、持久化对象自动跟新数据的能力、证明Session对象一级缓存的存在性
 */
public class StateTest {
	Session session;
	Transaction tr;

	// 执行单元测试之前进行的操作
	@Before
	public void init() {

		// 从连接池中获取一个连接
		session = DBConnPoolUtil.getConnection();

		// 开始事务
		tr = session.beginTransaction();
	}

	// 测试持久化对象的状态，查看调试，向数据库表customer添加一条数据
	@Test
	public void add() {

		// 创建一个customer
		Customer customer = new Customer();
		customer.setCust_name("alice");
		customer.setCust_level("1");
		customer.setCust_linkman("胡汉三");
		customer.setCust_mobile("16638118294");
		customer.setCust_address("郑州中原路");
		customer.setCust_phone("79897878");

		// 保存数据
		session.save(customer);
	}

	// 测试持久化对象自动更新数据的能力
	@Test
	public void update() {

		// 从数据库中取出一张表，并且更新数据
		Customer customer = session.get(Customer.class, 39L);
		customer.setCust_name("胡建");

		// 把内存中修改的数据刷入到数据库，不用进行update()操作
		// session.update(customer);
	}

	// 证明Session对象一级缓存的存在性
	@Test
	public void oneCache() {

		// 第一次取数据，从数据库查询，控制台日志打印sql语句
		Customer customer1 = session.get(Customer.class, 39L);
		System.out.println(customer1);

		// 第二次取数据，从缓存中查询，控制台日志不打印sql语句
		Customer customer2 = session.get(Customer.class, 39L);
		System.out.println(customer2);
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
