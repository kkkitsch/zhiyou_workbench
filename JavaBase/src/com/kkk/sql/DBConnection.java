package com.kkk.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DBConnection {

	static Connection con;
	static String driver;
	static String url;

	static {
		// 加载配置文件
		ResourceBundle resource = null;
		try {
			resource = new PropertyResourceBundle(new FileInputStream(new File("config/dbconnection.properties")));
			System.out.println("加载资源文件成功");
		} catch (IOException e) {
			System.out.println("加载资源文件失败");
			e.printStackTrace();
		}

		// 从配置文件中获取驱动、url
		driver = resource.getString("driver");
		url = resource.getString("url");

		// 加载驱动
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功");
		} catch (Exception e) {
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}
	}

	// 获取连接对象
	public static Connection getConnection() {

		// 获取连接
		try {
			con = DriverManager.getConnection(url);
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
}
