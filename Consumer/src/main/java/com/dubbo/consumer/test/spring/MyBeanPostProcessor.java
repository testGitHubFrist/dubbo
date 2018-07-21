package com.dubbo.consumer.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/21 19:05
 * @Description: 探讨spring BeanPostProcessor
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("[MyBeanPostProcessor] 这是BeanPostProcessor实现类构造器！");
    }

    public Object postProcessBeforeInitialization(Object o, String s)
            throws BeansException {
        System.out.println(
                "[postProcessBeforeInitialization] BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s)
            throws BeansException {
        System.out.println(
                "[postProcessAfterInitialization] BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return o;
    }
}
