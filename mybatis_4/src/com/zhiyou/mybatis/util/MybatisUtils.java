package com.zhiyou.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

	private static InputStream inputStream;

	public static SqlSessionFactory getSessionFactory() {
		try {
			inputStream = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static void close(SqlSession session) {
		if (session != null) {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
