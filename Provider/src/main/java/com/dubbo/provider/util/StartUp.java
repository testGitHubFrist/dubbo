package com.dubbo.provider.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class StartUp {
	private static final Logger logger = Logger.getLogger(StartUp.class);

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BasicConfigurator.configure();
			logger.info("生产者启动...........");
			com.alibaba.dubbo.container.Main.main(args);
			logger.info("生产者启动成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
