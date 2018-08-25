package com.zhiyou.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.User;
import com.zhiyou.util.DBConnPoolUtil;
import com.zhiyou.util.ManyToManyUtil;

public class TestHql {
	Session session;
	Transaction tr;

	// 执行单元测试之前进行的操作
	@Before
	public void init() {

		// 从连接池中获取一个连接
		session = ManyToManyUtil.getConnection();

		// 开始事务
		tr = session.beginTransaction();
	}

	// 查询所有
	@Test
	public void test1() {
		String hql = "from User";
		print(hql);
	}

	// 起别名 进行查询
	@Test
	public void test2() {
		String hql = "select u from User u";
		print(hql);
	}

	// 排序查询
	@Test
	public void test3() {
		String hql = "from User order by user_id desc";
		print(hql);
	}

	// 分页查询
	@Test
	public void test4() {
		String hql = "from User";
		Query<?> query = session.createQuery(hql);
		// 设置分页起始索引，从第二条
		query.setFirstResult(1);
		// 设置每页的数据个数，每页三个
		query.setMaxResults(3);
		print1(query);
	}

	// 条件检索
	@Test
	public void test5() {
		String hql = "from User where user_name like ?";
		Query<?> query = session.createQuery(hql);
		// 设置占位符的值
		query.setParameter(0, "%张%");
		print1(query);
	}

	// 另外一种条件查询
	@Test
	public void test6() {
		String hql = "from User where user_name like :name";
		Query<?> query = session.createQuery(hql);
		// 设置占位符的值
		query.setParameter("name", "%张%");
		print1(query);
	}

	@Test
	public void test7() {
		// HQL的投影查询,这种查询返回值类型为一个List集合的Ojbect数组，不方便查看，有一种更好的方式，让查询得到的返回类型为List<User>，做法就是
		// 将要查询的属性值在实体类中作为构造器
		String hql = "select u.user_name,u.user_password from User u ";
		Query<?> query = session.createQuery(hql);
		List<Object[]> data = (List<Object[]>) query.list();
		for (Object[] objects : data) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
	}

	private void print1(Query<?> query) {
		List<User> list = (List<User>) query.list();
		for (User user : list) {
			System.out.println(user);
		}
	}

	private void print(String hql) {
		Query<User> query = session.createQuery(hql);
		List<User> users = query.list();
		for (User user : users) {
			System.out.println(user);
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
