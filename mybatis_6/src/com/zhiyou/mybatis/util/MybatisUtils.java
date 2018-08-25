package com.zhiyou.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyou.mybatis.test.MultiTableOperation;

public class MybatisUtils {

	static InputStream inputStream;
	// 加载日志配置文件
	static Logger logger = null;

	static {
		logger = LoggerFactory.getLogger(MultiTableOperation.class);
	}

	public static SqlSessionFactory getSessionFactory() {
		try {
			// 在使用资源文件夹中的文件时，不用写资源文件夹的名称，直接引用文件的名称即可，文件的名称前不用加 /
			inputStream = Resources.getResourceAsStream("mybatis.xml");
			logger.info("加载配置文件成功");

			// 把所有配置文件的信息解析并保存在Configuration对象当中，返回的DefaultSqlSessionFactory对象包含Configuration对象的信息
			return new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			logger.info("加载配置文件失败");
			e.printStackTrace();
		}
		return null;
	}

	public static void close(SqlSession session) {
		if (session != null) {
			try {
				session.close();
				logger.info("已经关闭连接");
			} catch (Exception e) {
				logger.info("关闭连接失败");
				e.printStackTrace();
			}
		}
	}
}
