package com.dubbo.consumer.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/21 19:21
 * @Description:InstantiationAwareBeanPostProcessor 接口本质是BeanPostProcessor的子接口，
 * 一般我们继承Spring为其提供的适配器类InstantiationAwareBeanPostProcessor Adapter来使用它
 */
public class MyInstantiationAwareBeanPostProcessor
        extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("[InstantiationAwareBeanPostProcessorAdapter]");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("[InstantiationAwareBeanPostProcessorAdapter]");
        return bean;
    }
}
