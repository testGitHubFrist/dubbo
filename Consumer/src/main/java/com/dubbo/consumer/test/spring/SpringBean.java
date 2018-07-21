package com.dubbo.consumer.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/21 16:59
 * @Description: 探讨springbean的生命周期；实现BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean
 */
public class SpringBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        InitializingBean, DisposableBean {

    private String contextId;

    private BeanFactory beanFactory;

    private String beanName;

    private ClassLoader classLoader;

    //无参构造函数。默认实例化为无参构造函数实例化
    public SpringBean() {
        System.out.println("[构造器] 调用SpringBean的构造器实例化");
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        System.out.println("[注入属性] 注入属性contextId");
        this.contextId = contextId;
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println(
                "[BeanClassLoaderAware接口] 调用BeanClassLoaderAware.setBeanClassLoader");

    }

    // 这是BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[BeanFactoryAware接口] 调用BeanFactoryAware.setBeanFactory");
        this.beanFactory = beanFactory;
    }

    // 这是BeanNameAware接口方法
    public void setBeanName(String s) {
        System.out.println("[BeanNameAware接口] 调用BeanNameAware.setBeanName");
        this.beanName = s;
    }

    // 这是DiposibleBean接口方法
    public void destroy() throws Exception {
        System.out.println("[DiposibleBean接口] 调用DiposibleBean.destroy");
    }

    // 这是InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("[InitializingBean接口] 调用InitializingBean.afterPropertiesSet");

    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("[init-method] 调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestroy() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }

    @Override
    public String toString() {
        return "SpringBean{" + "contextId='" + contextId + '\'' + ", beanFactory="
                + beanFactory + ", beanName='" + beanName + '\'' + ", classLoader="
                + classLoader + '}';
    }
}
