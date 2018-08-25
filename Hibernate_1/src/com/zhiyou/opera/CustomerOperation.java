package com.zhiyou.opera;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.Customer;
import com.zhiyou.util.DBConnPoolUtil;

/**
 * @author 健康的小海豹
 * @description 对Customer类进行一些CRUD操作
 */
public class CustomerOperation {

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

	// 向数据库表customer添加一条数据
	@Test
	public void add() {

		// 创建一个customer
		Customer customer = new Customer();
		customer.setCust_name("alice");
		customer.setCust_level("1");
		customer.setCust_linkman("胡汉三");
		customer.setCust_mobile("16638118294");
		customer.setCust_address("郑州中原路");
		customer.setCust_phone("19960806");

		// 保存数据,返回主键值
		Serializable save = session.save(customer);
		System.out.println(save);

	}

	// 获取一条数据
	@Test
	public void get() {
		Customer customer = session.get(Customer.class, 24L);
		System.out.println("获取的记录：" + customer);
	}

	// 更新一条数据
	@Test
	public void update() {
		Customer customer = session.get(Customer.class, 24L);
		customer.setCust_name("胡铁花");
		session.update(customer);
	}

	// 删除一条记录
	@Test
	public void delete() {
		Customer customer = session.get(Customer.class, 26);
		session.delete(customer);
	}

	// 查询所哟数据
	@Test
	public void queryAll() {
		// 返回一个Query接口，面向Java bean，hql语句中不能出现表名，只能出现java bean的名字
		Query<Customer> query = session.createQuery("from Customer");

		// Query接口的list()方法返回所有数据
		List<Customer> customers = query.list();

		for (Customer customer : customers) {
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
