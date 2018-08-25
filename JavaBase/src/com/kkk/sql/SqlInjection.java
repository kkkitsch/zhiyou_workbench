package com.kkk.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

public class SqlInjection {

	Connection con;
	PreparedStatement ps;

	/*
	 * 使用传统方式测试sql注入
	 * 
	 * 我们正常输入账号密码是运行正确的，但是当我们账号输入：kjaskj' or 1=1 # 密码输入：klkjl; 就会出现以下的结果：
	 * 
	 * 欢迎张三回来,此时,sql语句是这样的:
	 * 
	 * select * from users where user ='kjaskj'or1=1#' and password ='"+pwd+"'
	 * 
	 * 上面是一整条sql语句,没有参数之类的
	 * 
	 * 当然这里也有办法阻止此类事件的发生。
	 * 
	 * 在代码中间插入一个替换一句，将该方法中所有的单引号替换成双引号，就不会发生类似的事情
	 * 
	 */
	@Test
	public void test() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("账号：");
		String uid = sc.nextLine();
		System.out.println("密码：");
		String pwd = sc.nextLine();

		con = DBConnection.getConnection();
		Statement st = con.createStatement();

		// uid = uid.replace("\'", "\"");// 替换单双引号,防止sql注入

		String sql = "select * from customer where customer_id='" + uid + "' and  customer_name='" + pwd + "'  ";
		if (st.executeQuery(sql).next()) {
			System.out.println("欢迎回来:" + uid);
		} else {
			System.out.println("密码错误");
		}
	}

	/*
	 * 使用预编译语句,防止绝大多数的sql注入
	 */
	@Test
	public void test1() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("账号：");
		String uid = sc.next();
		System.out.println("密码：");
		String pwd = sc.next();

		con = DBConnection.getConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select * from customer where customer_id=? and customer_name=?");
		pstmt.setString(1, uid);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			System.out.println("欢迎回来:" + uid);
		} else {
			System.out.println("密码错误");
		}
	}
}
