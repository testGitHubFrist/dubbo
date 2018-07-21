package com.dubbo.consumer.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/21 19:48
 * @Description: spring bean生命周期测试
 */
public class BeanLifeCycle {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");
        ApplicationContext factory = new ClassPathXmlApplicationContext("springBeanTest/beans.xml");
        System.out.println("容器初始化成功");
        SpringBean springBean=factory.getBean("springBean",SpringBean.class);
        System.out.println(springBean);
        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
