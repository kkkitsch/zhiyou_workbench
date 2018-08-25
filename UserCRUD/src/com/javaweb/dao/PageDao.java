package com.javaweb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.javaweb.entity.User;
import com.javaweb.util.DruidUtil;

public class PageDao {

	static QueryRunner queryRunner;
	static{
		//dataSource 在容器启动的时候 进行的初始化 
		 queryRunner = new QueryRunner(DruidUtil.dataSource);
	}
	//获取总的记录数
	public long getToalSize(){
		try {
			ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
			long i = (long) queryRunner.query("select count(*) from user",scalarHandler);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//获取当前页的数据 
	public List<User> getCurrentPage(int currentPage,int pageSize){
		try {
			BeanListHandler<User> beanListHandler = new BeanListHandler<>(User.class);
			List<List<User>> result = queryRunner.execute("select * from user limit ?,?",beanListHandler,(currentPage-1)*pageSize,pageSize );
			return result.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
