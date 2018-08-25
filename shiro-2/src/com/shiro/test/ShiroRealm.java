package com.shiro.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import com.shiro.utils.DBConnection;

//realm 需要查询数据库 并且得到正确的数据
public class ShiroRealm extends AuthenticatingRealm {

	/*
	 * 1、doGetAuthenticationInfo
	 * ，获取认证消息，如果数据库没有数据，返回null，如果得到正确的用户名和密码，返回指定类型的对象
	 * 
	 * 2、AuthenticationInfo 可以使用SimpleAuthenticationInfo子类实现类，封装给你正确的用户名和密码
	 * 
	 * 3、token参数 就是我们需要认证的token
	 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		SimpleAuthenticationInfo info = null;

		// 1、将token转换成UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 2、获取登录用户名即可
		String username = upToken.getUsername();
		// 3、查询数据库，是否存在指定用户名和密码的用户
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from t_shiro where name=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// 数据库中的用户名和密码
				Object principal = username;
				Object credentials = rs.getString(3);
				String realmName = this.getName();
				System.out.println("第一个ShiroRealm正在工作，realmName：:" + realmName);

				/*
				 * 定义盐值加密，使用登录用户的username作为加密的佐料，这样一来，即使不同用户的密码相同，但是因为使用了盐值加密，所以
				 * 在数据库中保存的加密密码也不一样
				 * 
				 * 用户jim的密码盐值加密后：cb4c96296c04ddbe3cdd8b551be0109b
				 * 
				 * 用户alice的密码盐值加密后：a5aec45bc54bc1eefad14697e89713ab
				 */
				ByteSource salt = ByteSource.Util.bytes(username);

				// 将数据库中的明文密码进行MD5加密1024次，并且使用盐值加密
				SimpleHash sh = new SimpleHash("MD5", credentials, salt, 1024);

				/*
				 * 在此，会将用户输入封装成的token和info作对比，返回布尔类型的值
				 * SimpleCredentialsMatcher类中的方法： public boolean
				 * doCredentialsMatch(AuthenticationToken token,
				 * AuthenticationInfo info) { Object tokenCredentials =
				 * getCredentials(token); Object accountCredentials =
				 * getCredentials(info); return equals(tokenCredentials,
				 * accountCredentials); }
				 */

				// 数据库中的加密密码和用户输入的密码进行加密后作比较
				// info = new SimpleAuthenticationInfo(principal, credentials,
				// realmName);

				// 数据库中的明文密码进行加密后和用户输入的密码进行加密后作比较，正常情况下不应该这样
				// info = new SimpleAuthenticationInfo(principal, sh,
				// realmName);

				// 盐值加密后，数据的比较
				info = new SimpleAuthenticationInfo(principal, sh, salt, realmName);

			} else {
				// 如果没有 查询到，抛出一个异常
				throw new AuthenticationException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 如果查询到了，封装查询结果，返回给我们的调用
		return info;
	}

}
