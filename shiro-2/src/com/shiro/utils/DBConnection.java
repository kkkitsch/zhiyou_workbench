package com.shiro.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {

	// 获取连接对象
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功");
		} catch (Exception e) {
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false&&user=root&&password=kkkitsch");
			System.out.println("建立连接成功");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("建立连接失败");
			return null;
		}
	}

	// 关闭连接
	public static void close(Connection con, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
			System.out.println("关闭连接成功");
		} catch (Exception e) {
			System.out.println("关闭连接失败");
			e.printStackTrace();
		}
	}

	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
			System.out.println("关闭连接成功");
		} catch (Exception e) {
			System.out.println("关闭连接失败");
			e.printStackTrace();
		}
	}
}
