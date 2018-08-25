package com.javaweb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaweb.costant.PageEnum;
import com.javaweb.dao.PageDao;
import com.javaweb.entity.PageBean;
import com.javaweb.entity.User;

public class PageService {

	Logger logger = LoggerFactory.getLogger(PageService.class);

	public PageBean getPageBean(String currentPage) {

		if (logger.isInfoEnabled()) {
			logger.info("获取的当前页为：{}", currentPage);
		}
		Integer currentPageInteger = 0;
		if (currentPage != null) {
			currentPageInteger = Integer.valueOf(currentPage);
		}

		PageDao pageDao = new PageDao();
		// 总记录数
		long totalSize = pageDao.getToalSize();
		if (logger.isInfoEnabled()) {
			logger.info("获取的总记录数为：{}", totalSize);
		}
		// 总的页码
		int totalPage = (int) (totalSize % PageEnum.PageSize.size == 0 ? totalSize / PageEnum.PageSize.size
				: (totalSize / PageEnum.PageSize.size) + 1);
		// int totalPage = (int)Math.ceil(totalSize / PageEnum.PageSize.size)+1;
		if (logger.isInfoEnabled()) {
			logger.info("获取的总页数为：{}", totalPage);
		}
		// 当前页的数据
		List<User> currentPageUser = pageDao.getCurrentPage(currentPageInteger, PageEnum.PageSize.size);
		if (logger.isInfoEnabled()) {
			logger.info("获取的当前页的数据为：{}", currentPageUser);
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPageInteger);
		pageBean.setTotalPage(totalPage);
		pageBean.setUserList(currentPageUser);

		if (logger.isInfoEnabled()) {
			logger.info("返回到当前页的数据为：{}", pageBean);
		}
		return pageBean;
	}

}
