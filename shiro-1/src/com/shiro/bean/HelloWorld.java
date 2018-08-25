package com.shiro.bean;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	// 定义一个日志输出器
	private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		// 测试向控制台输出
		log.info("我们正在测试Log4j");

		// 1、获取 安全管理器
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		// 2、需要设置安全管理器
		SecurityUtils.setSecurityManager(securityManager);

		// 3、获取Subject对象，即将登陆的用户
		Subject currentUser = SecurityUtils.getSubject();

		// 获取一个session
		Session session = currentUser.getSession();
		// 为session设置属性
		session.setAttribute("name", "kkkitsch");
		// 获取session当中额属性
		String value = (String) session.getAttribute("name");
		if (value != null) {
			log.info("shiro已经帮我们获取到了session回话当中指定的值：" + value);
		}

		// 判断这个对象是否 是有效的 Authenticated：真实的 有效的
		if (currentUser.isAuthenticated() == false) {
			// 设置一个账号和密码
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				log.info("用户名和密码正确，登录成功");
			} catch (UnknownAccountException e) {
				log.info("账户不存在");
			} catch (IncorrectCredentialsException e) {
				log.info("密码错误");
			} catch (LockedAccountException e) {
				log.info("用户已经锁死");
			} catch (AuthenticationException e) {
				log.info("认证异常");
			}
		}

		// 判断subject是否拥有某个角色
		if (currentUser.hasRole("schwartz")) {
			log.info("拥有指定的角色");
		} else {
			log.info("不拥有指定的角色");
		}

		// 判断subject是否拥有指定的权限
		if (currentUser.isPermitted("winnebago:drive:eagle5")) {
			log.info("拥有指定的权限");
		} else {
			log.info("没有指定的权限");
		}

		// subject退出
		currentUser.logout();
		System.exit(0);

	}
}
