package com.kkk.sql;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidAndDHCPConnectionPool {
	static DataSource ds;
	static Properties pro;
	static InputStream inputStream;
	static Connection con;

	// 加载配置文件资源
	static {
		pro = new Properties();
		try {
			inputStream = new BufferedInputStream(new FileInputStream(new File("config/druid.properties")));
			System.out.println("文件配置成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到");
		}
		try {
			pro.load(inputStream);
			System.out.println("文件加载成功");
		} catch (IOException e) {
			System.out.println("加载配置文件失败");
			e.printStackTrace();
		}
	}

	// 获取连接对象
	public static Connection getConnection() throws IOException {
		// 获取连接
		try {

			// //使用DHCP连接池获取连接对象
			// ds = DruidDataSourceFactory.createDataSource(pro);

			// 使用德鲁伊连接池获取连接对象
			ds = DruidDataSourceFactory.createDataSource(pro);
			con = ds.getConnection();

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
