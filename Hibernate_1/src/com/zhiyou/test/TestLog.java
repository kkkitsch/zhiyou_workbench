package com.zhiyou.test;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {

	// 加载日志配置文件
	static Logger logger = null;
	static {
		PropertyConfigurator.configure("config/log4j.properties");
		// 使用log4j打印日志
		// logger = Logger.getLogger(TestLog.class);
		// 使用slf4j打印日志
		logger = LoggerFactory.getLogger(TestLog.class);
	}

	@Test
	public void test1() {
		// 测试输出日志级别
		logger.debug("this is debug ");
		logger.info("this is info");
		logger.warn("this is warn");
		logger.error("this is error");
		// slf4j没有fatal()方法
		// logger.fatal("this is fatal");
	}
}
