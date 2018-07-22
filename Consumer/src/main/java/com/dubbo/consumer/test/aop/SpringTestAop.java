package com.dubbo.consumer.test.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/22 11:33
 * @Description: spring AOP测试类
 */
public class SpringTestAop {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springAopTest/aop.xml");//BeanDefination的解析注册，代理对象的生成
        Dao userDao = (Dao) applicationContext.getBean("dao");//可以看到userDao类型是以$Proxy开头的，说明是通过JDK动态代理的方式获取的
        userDao.add();//增强行为发生的时刻
        userDao.delete();
    }
}
