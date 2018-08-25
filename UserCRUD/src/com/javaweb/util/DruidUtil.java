package com.javaweb.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {

	// 避免DataSource 数据源创建多次 
	// 在类加载的时候即初始化一次
	static Properties properties;
	public static DataSource dataSource;
	
	static{
		properties = new Properties();
		try {
			properties.load(DruidUtil.class.getClassLoader().getResourceAsStream("alibaba.properties"));
			getDataSource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource(){
		try {
			 dataSource = DruidDataSourceFactory.createDataSource(properties);
			return dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeDataSource() {
		DruidDataSource druidDataSource = (DruidDataSource) dataSource;
		druidDataSource.close();
	}
	
	public static Connection getConnection(){
		try {
			Connection connection = dataSource.getConnection();
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(DataSource dataSource,Connection conn,PreparedStatement preparedStatement,ResultSet resultSet){
		
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(dataSource!=null){
			DruidDataSource source=(DruidDataSource)dataSource;
			source.close();
		}
		
	}
	public static void main(String[] args) throws SQLException {
		DruidDataSource dataSource = (DruidDataSource)DruidUtil.getDataSource();
		System.out.println(dataSource.getConnection());
		DruidDataSource dataSource2 = (DruidDataSource)DruidUtil.getDataSource();
		System.out.println(dataSource2.getConnection());
	}
	
}
