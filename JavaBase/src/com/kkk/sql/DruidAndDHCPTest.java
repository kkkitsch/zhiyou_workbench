package com.kkk.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class DruidAndDHCPTest {

	Connection con;
	PreparedStatement ps;

	/*
	 * 在people表中查询所有数据
	 */
	@Test
	public void queryAll() throws Exception {

		// 使用德鲁伊连接池获取获取连接
		con = DruidAndDHCPConnectionPool.getConnection();

		// 使用DHCP连接池获取获取连接
		// con = DruidAndDHCPConnectionPool.getConnection();

		// sql查询语句
		ps = con.prepareStatement("select * from people");
		// 执行查询
		ResultSet rs = ps.executeQuery();
		// 表中的一条记录对应着一个对象
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "===>" + rs.getString(2) + "===>" + rs.getString(3));
		}
		DBConnection.close(con, ps);
	}
}
