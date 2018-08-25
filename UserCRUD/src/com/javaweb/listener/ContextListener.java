package com.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaweb.util.DruidUtil;

@WebListener
public class ContextListener implements ServletContextListener {

	Logger logger = LoggerFactory.getLogger(ContextListener.class);

	public ContextListener() {
	}

	// Tomcat容器启动的时候调用 用于初始化数据源
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("com.javaweb.util.DruidUtil");
			if (logger.isInfoEnabled()) {
				logger.info("数据源初始化完成");
			}
		} catch (ClassNotFoundException e) {
			logger.info("数据源初始化失败");
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		DruidUtil.closeDataSource();
		if (logger.isInfoEnabled()) {
			logger.info("数据源已关闭");
		}
	}

}
