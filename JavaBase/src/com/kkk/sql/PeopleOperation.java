package com.kkk.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

/**
 * @description 在people表中做一些简单的增删改查
 * @author KKKITSCH
 *
 */
/*
 * jdbc中,增删改用:executeUpdate()方法,返回的是受影响的行数,查询用:executeQuery(),返回的是查询得到的结果集
 * 
 * 使用后,要关闭连接,先创建的连接后关闭
 */
public class PeopleOperation {
	static Connection con;
	PreparedStatement ps;

	static {
		// 获取连接
		con = DBConnection.getConnection();
	}

	/*
	 * 在people表中插入一条数据，如果数据库中设置了自增id，仍然可以在插入时指定id，再次插入时，如果不指定id，则从上次插入的id+
	 * 1开始自增id，
	 */
	@Test
	public void save() throws Exception {

		// 插入的值的数量必须与表的字段的数量对应
		ps = con.prepareStatement("insert into people(p_name,p_age) values('llh',16)");
		// 执行插入操作 返回的是受影响的行数
		int num = ps.executeUpdate();
		// 返回 值大于0说明插入成功
		if (num > 0) {
			System.out.println("执行插入成功");
		} else {
			System.out.println("执行插入失败");
		}

		// 在插入一条新的数据时，获取自增id
		getId();

		// 关闭数据库连接
		DBConnection.close(con, ps);
	}

	/*
	 * 在people表中删除一条记录
	 */
	@Test
	public void delete() throws Exception {
		// 获取连接
		con = DBConnection.getConnection();
		ps = con.prepareStatement("delete from people where p_id=?");
		// 设置占位符的值，从1开始
		ps.setInt(1, 22);
		// 执行插入操作 返回的是受影响的行数
		int num = ps.executeUpdate();
		// 返回 值大于0说明插入成功
		if (num > 0) {
			System.out.println("删除记录成功！");
		} else {
			System.out.println("删除记录失败！");
		}
		DBConnection.close(con, ps);
	}

	/*
	 * 在people表中修改一条记录
	 */
	@Test
	public void update() throws Exception {
		// 获取连接
		con = DBConnection.getConnection();
		ps = con.prepareStatement("update people set p_name = 'joyma' where p_id = ?");
		// 设置占位符的值，从1开始
		ps.setInt(1, 14);

		// 执行插入操作 返回的是受影响的行数 返回值大于0说明插入成功
		if (ps.executeUpdate() > 0) {
			System.out.println("更新记录成功！");
		} else {
			System.out.println("更新记录失败！");
		}
		DBConnection.close(con, ps);
	}

	/*
	 * 在people表中查询所有数据
	 */
	@Test
	public void queryAll() throws Exception {
		// 获取连接
		con = DBConnection.getConnection();
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

	/*
	 * 获取自增id
	 */
	private void getId() throws SQLException {

		/*
		 * 第一种方式获取自增id:使用max()聚合函数获取id的最大值
		 */
		// ps = con.prepareStatement("select max(p_id) from people");
		// ResultSet rs = ps.executeQuery();
		// while (rs.next()) {
		// System.out.println("新插入的数据自增id为： " + rs.getString(1));
		// }

		/*
		 * 第二种方式获取自增id:使用系统函数：LAST_INSERT_ID()，不需要加上：from
		 * people，如果加上了，那就是获取所有的id
		 */
		ps = con.prepareStatement("select LAST_INSERT_ID()");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("新插入的数据自增id为： " + rs.getString(1));
		}

		/*
		 * 第三种方式：使用 @@IDENTITY 获取id，不需要加上：from people，如果加上了，那就是获取所有的id
		 */
		// ps = con.prepareStatement("select @@IDENTITY");
		// ResultSet rs = ps.executeQuery();
		// while (rs.next()) {
		// System.out.println("新插入的数据自增id为： " + rs.getString(1));
		// }

	}

}
