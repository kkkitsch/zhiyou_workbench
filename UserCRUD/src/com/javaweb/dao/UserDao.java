package com.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.javaweb.entity.User;
import com.javaweb.util.DruidUtil;

/**
 * 数据访问 层
 * @author Administrator
 *
 */
public class UserDao {
	
	static QueryRunner queryRunner;
	static{
		//dataSource 在容器启动的时候 进行的初始化 
		 queryRunner = new QueryRunner(DruidUtil.dataSource);
	}

	public User getUserByEmail(String email){
		List<User> result;
		try {
			result = queryRunner.execute("select * from user where email =?", new BeanHandler<>(User.class),email);
			return result.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteUser(int id){
		try {
			int i = queryRunner.update("delete from user where id = ? ",id);
			if(i > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateUser(String username,String email,String password,int id){
		int update;
		try {
			update = queryRunner.execute("update user set username = ?,email = ?,password = ? where id = ? ",username,email,password,id);
			if(update>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUserById(int id){
		List<User> result;
		try {
			result = queryRunner.execute("select * from user where id =?", new BeanHandler<>(User.class),id);
			return result.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addUser(String username,String email,String password){
		int update;
		try {
			update = queryRunner.execute("insert into user(username,email,password) values(?,?,?)",username,email,password);
			if(update > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	
	public boolean deleteUserById(int id){
		
		try {
			int update = queryRunner.update("delete from user where id = ? ",id);
			if(update>0){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {		
			//TODO QueryRunner 除了数据源 其他自己处理 
		}
		return false;
	}
	
	public List<User>  getAllUserByApache(){
		// 用于处理实体bean的结果集
		BeanListHandler<User> beanListHandler = new BeanListHandler<>(User.class);
		List<List<User>> execute=null;
		
		try {
			execute = queryRunner.execute("select * from user",beanListHandler);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//queryRunner.execute("select * from user", new BeanListHandler<>(User.class));
		return execute.get(0);
	}
	
	public List<User> getAllUser(){
		Connection connection = DruidUtil.getConnection();
		List<User> userList = new ArrayList<>();
		PreparedStatement prepareStatement=null;
		ResultSet resultSet=null;
		try {
			 prepareStatement = connection.prepareStatement("select * from user");
			 resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				//一条记录 对应一个User对象; 有几条记录 new 几个user实例
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername("java12="+resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				userList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DruidUtil.close(null, connection, prepareStatement, resultSet);
		}
		return userList;
	}
}
