package com.zhiyou.multable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.Role;
import com.zhiyou.bean.User;
import com.zhiyou.util.DBConnPoolUtil;
import com.zhiyou.util.ManyToManyUtil;

public class ManyToMany {

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

	@Test // 双向关联
	public void add() {

		// 新建两个用户
		User u1 = new User();
		u1.setUser_name("陈冠希");
		u1.setUser_password("111111");
		u1.setUser_state("1");

		User u2 = new User();
		u2.setUser_name("张柏芝");
		u2.setUser_password("666666");
		u2.setUser_state("0");

		// 新建两个角色
		Role r1 = new Role();
		r1.setRole_name("演员");
		r1.setRole_memo("其实，我是一个演员");

		Role r2 = new Role();
		r2.setRole_name("歌手");
		r2.setRole_memo("其实，我是一个演员");

		// 陈冠希：演员+歌手
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);

		// 张柏芝：演员
		u2.getRoles().add(r1);
		r1.getUsers().add(u2);

		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
	}

	@Test // user关联role
	public void add1() {

		// 新建两个用户
		User u1 = new User();
		u1.setUser_name("陈冠希");
		u1.setUser_password("111111");
		u1.setUser_state("1");

		User u2 = new User();
		u2.setUser_name("张柏芝");
		u2.setUser_password("666666");
		u2.setUser_state("0");

		// 新建两个角色
		Role r1 = new Role();
		r1.setRole_name("演员");
		r1.setRole_memo("其实，我是一个演员");

		Role r2 = new Role();
		r2.setRole_name("歌手");
		r2.setRole_memo("其实，我是一个演员");

		// 陈冠希：演员+歌手
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);

		// 张柏芝：演员
		u2.getRoles().add(r1);

		session.save(u1);
		session.save(u2);
	}

	// 级联删除
	@Test
	public void delete() {
		User user = session.get(User.class, 53L);
		user.getRoles();
		session.delete(user);
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