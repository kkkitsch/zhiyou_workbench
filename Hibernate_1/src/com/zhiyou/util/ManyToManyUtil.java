package com.zhiyou.util;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyUtil {

	static Configuration config;

	static SessionFactory factory;

	static {

		// 1、读取配置文件hibernate.cfg.xml，获取连接池
		config = new Configuration();
		config.configure(new File("config/hibernate_many_to_many.xml"));
		System.out.println("读取配置文件成功");

		factory = config.buildSessionFactory();
		System.out.println("获取连接池成功");

	}

	public static Session getConnection() {

		// 2、从连接池中获取一个连接
		return factory.openSession();
	}

	// 获取绑定到线程的Session对象
	public static Session getCurrentSession() {
		return factory.getCurrentSession();
	}

	public static void close(Session session) {

		try {
			if (factory != null) {
				factory.close();
			}
			if (session != null) {
				session.close();
			}
			System.out.println("连接已关闭");
		} catch (Exception e) {
			System.out.println("连接关闭失败");
			e.printStackTrace();
		}

	}
}
