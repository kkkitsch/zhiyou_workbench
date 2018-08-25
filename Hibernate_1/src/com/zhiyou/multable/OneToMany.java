package com.zhiyou.multable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou.bean.Customer;
import com.zhiyou.bean.LinkMan;
import com.zhiyou.util.DBConnPoolUtil;

public class OneToMany {

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

	// 双向关联
	@Test
	public void add() {
		// 创建一个customer
		Customer customer = new Customer();
		customer.setCust_name("matty");
		customer.setCust_level("3");
		customer.setCust_linkman("juddy");
		customer.setCust_mobile("16638118294");
		customer.setCust_address("地方镇");
		customer.setCust_phone("19960806");

		// 创建两个联系人
		LinkMan man1 = new LinkMan();
		man1.setLkm_name("smisy");
		man1.setLkm_gender("F");
		man1.setLkm_phone("77988678");
		man1.setLkm_mobile("13791273921");
		man1.setLkm_email("1281053497@qq.com");
		man1.setLkm_qq("1280153497");
		man1.setLkm_position("布宜诺斯艾利斯");
		man1.setLkm_memo("this is a memo");

		LinkMan man2 = new LinkMan();
		man2.setLkm_name("kate");
		man2.setLkm_gender("F");
		man2.setLkm_phone("77988678");
		man2.setLkm_mobile("13791273921");
		man2.setLkm_email("1281053497@qq.com");
		man2.setLkm_qq("1280153497");
		man2.setLkm_position("密西西比州");
		man2.setLkm_memo("this is a memo");

		// 双向关联
		customer.getLinkMans().add(man1);
		customer.getLinkMans().add(man2);
		man1.setCustomer(customer);
		man2.setCustomer(customer);

		// 保存
		session.save(customer);
		session.save(man1);
		session.save(man2);

	}

	// 单向关联，客户关联联系人
	@Test
	public void add1() {

		// 创建一个customer
		Customer customer = new Customer();
		customer.setCust_name("派大星");
		customer.setCust_level("3");
		customer.setCust_linkman("juddy");
		customer.setCust_mobile("16638118294");
		customer.setCust_address("海底世界");
		customer.setCust_phone("19960806");

		// 创建两个联系人
		LinkMan man1 = new LinkMan();
		man1.setLkm_name("海星");
		man1.setLkm_gender("F");
		man1.setLkm_phone("77988678");
		man1.setLkm_mobile("13791273921");
		man1.setLkm_email("1281053497@qq.com");
		man1.setLkm_qq("1280153497");
		man1.setLkm_position("珊瑚礁");
		man1.setLkm_memo("this is a memo");

		LinkMan man2 = new LinkMan();
		man2.setLkm_name("不星");
		man2.setLkm_gender("F");
		man2.setLkm_phone("77988678");
		man2.setLkm_mobile("13791273921");
		man2.setLkm_email("1281053497@qq.com");
		man2.setLkm_qq("1280153497");
		man2.setLkm_position("不知道星球");
		man2.setLkm_memo("this is a memo");

		// 单向关联
		customer.getLinkMans().add(man1);
		customer.getLinkMans().add(man2);

		// 只保存客户
		session.save(customer);

	}

	// 单向关联，联系人关联客户
	@Test
	public void add2() {

		// 创建一个customer
		Customer customer = new Customer();
		customer.setCust_name("塔坦");
		customer.setCust_level("3");
		customer.setCust_linkman("juddy");
		customer.setCust_mobile("16638118294");
		customer.setCust_address("荆棘星球");
		customer.setCust_phone("19960806");

		// 创建两个联系人
		LinkMan man1 = new LinkMan();
		man1.setLkm_name("洛洛洛");
		man1.setLkm_gender("F");
		man1.setLkm_phone("77988678");
		man1.setLkm_mobile("13791273921");
		man1.setLkm_email("1281053497@qq.com");
		man1.setLkm_qq("1280153497");
		man1.setLkm_position("荆棘星球");
		man1.setLkm_memo("this is a memo");

		LinkMan man2 = new LinkMan();
		man2.setLkm_name("剪纸");
		man2.setLkm_gender("F");
		man2.setLkm_phone("77988678");
		man2.setLkm_mobile("13791273921");
		man2.setLkm_email("1281053497@qq.com");
		man2.setLkm_qq("1280153497");
		man2.setLkm_position("荆棘星球");
		man2.setLkm_memo("this is a memo");

		// 单向关联
		man1.setCustomer(customer);
		man2.setCustomer(customer);

		// 只保存联系人
		session.save(man1);
		session.save(man2);

	}

	// 删除客户
	@Test
	public void delete() {
		Customer customer = session.get(Customer.class, 47L);
		session.delete(customer);
	}

	// 删除联系人
	@Test
	public void delete1() {
		LinkMan man = session.get(LinkMan.class, 44);
		session.delete(man);
	}

	// 孤儿删除：只是将多方在代码中定义的一条记录删除，其他记录依然在，一方的记录也在
	@Test
	public void delete2() {

		// 创建一个客户
		Customer customer = session.get(Customer.class, 52L);
		System.out.println(customer);

		// 创建一个和客户有联系的联系人
		LinkMan man = session.get(LinkMan.class, 51);

		// 将这个联系人和客户的关系移除
		customer.getLinkMans().remove(man);

		// 解除关系，使用了快照机制
	}

	// 测试 让某一方放弃外键的维护,进行双向关联
	@Test
	public void testInverse() {
		// 创建一个客户
		Customer customer = session.get(Customer.class, 55L);

		// 创建一个和客户有联系的联系人
		LinkMan man = session.get(LinkMan.class, 57);

		// 双向关联
		customer.getLinkMans().add(man);
		man.setCustomer(customer);

		// 双向保存
		session.save(customer);
		session.save(man);

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
