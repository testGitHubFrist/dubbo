package com.dubbo.consumer.test.aop;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/22 11:29
 * @Description: 切入函数
 */
public class Logger {
    public void recordBefore() {
        System.out.println("[Logger] recordBefore()");
    }

    public void recordAfter() {
        System.out.println("[Logger] recordAfter()");
    }
}
