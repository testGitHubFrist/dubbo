package com.dubbo.provider.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartUp {
    private static final Logger logger = LoggerFactory.getLogger(StartUp.class);

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            logger.info("生产者启动...........");
            com.alibaba.dubbo.container.Main.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
