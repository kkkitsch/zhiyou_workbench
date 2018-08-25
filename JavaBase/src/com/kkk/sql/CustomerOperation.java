package com.kkk.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @description 多表查询中的一些简单操作
 * @author KKKITSCH
 *
 */
public class CustomerOperation {
	Connection con;
	PreparedStatement ps;

	/*
	 * 在customer表中查询部分数据
	 */
	@Test
	public void query() throws Exception {
		// 获取连接
		con = DBConnection.getConnection();
		// sql查询语句
		ps = con.prepareStatement("select  customer_name,customer_id,customer_mobile from customer LIMIT 2,6");
		// 执行查询
		ResultSet rs = ps.executeQuery();
		// 表中的一条记录对应着一个对象
		while (rs.next()) {
			// 获取列的属性,下标从1开始
			System.out.println(rs.getString(1) + "=====>" + rs.getString(2) + "===>" + rs.getString(3));
		}
		DBConnection.close(con, ps);
	}

	/*
	 * 多表查询之内连接查询
	 */
	@Test
	public void query1() throws Exception {
		// 获取连接
		con = DBConnection.getConnection();
		// sql查询语句
		ps = con.prepareStatement(
				"select customer_name,GROUP_CONCAT(order_name),SUM(order_price*order_num) FROM customer ,`order` where customer.customer_id=`order`.order_cust_id GROUP BY customer_name");
		// 执行查询
		ResultSet rs = ps.executeQuery();
		// 表中的一条记录对应着一个对象
		while (rs.next()) {
			System.out.println("用户名：" + rs.getString(1) + "\t购买的商品：" + rs.getString(2));
			System.out.println("总价：" + rs.getString(3) + "\n");
		}
		DBConnection.close(con, ps);
	}

	/*
	 * 多表查询之右外连接查询
	 */
	@Test
	public void query2() throws Exception {
		// 获取连接
		con = DBConnection.getConnection();
		// sql查询语句
		ps = con.prepareStatement(
				"select customer.customer_name,customer.customer_mobile,customer.customer_address,`order`.order_name FROM customer RIGHT JOIN `order` ON customer.customer_id=`order`.order_cust_id");
		// 执行查询
		ResultSet rs = ps.executeQuery();
		// 表中的一条记录对应着一个对象
		while (rs.next()) {
			System.out.println("用户名：" + rs.getString(1));
			System.out.println("用户手机：" + rs.getString(2));
			System.out.println("用户地址：" + rs.getString(3));
			System.out.println("商品名：" + rs.getString(4));
			System.out.println("==========================");
		}
		DBConnection.close(con, ps);
	}

	/*
	 * 多表查询之左外连接查询
	 */
	@Test
	public void query3() throws Exception {
		// 获取连接
		con = DBConnection.getConnection();
		// sql查询语句
		ps = con.prepareStatement(
				"select customer.customer_name,customer.customer_mobile,customer.customer_address,`order`.order_name FROM customer LEFT JOIN `order` ON customer.customer_id=`order`.order_cust_id");
		// 执行查询
		ResultSet rs = ps.executeQuery();
		// 表中的一条记录对应着一个对象
		while (rs.next()) {
			System.out.println("用户名：" + rs.getString(1));
			System.out.println("用户手机：" + rs.getString(2));
			System.out.println("用户地址：" + rs.getString(3));
			System.out.println("商品名：" + rs.getString(4));
			System.out.println("==========================");
		}
		DBConnection.close(con, ps);
	}

}
