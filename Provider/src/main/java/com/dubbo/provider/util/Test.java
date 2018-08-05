package com.dubbo.provider.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Test {
    private static final Logger logger = Logger.getLogger(Test.class);

    //	public static void main(String[] args) {
//		testLog();
//	}
//	@org.junit.Test
    public void testLog() {
        BasicConfigurator.configure();
        logger.debug("my first log4j info");
        logger.debug("debug");
        logger.error("error");
    }
}