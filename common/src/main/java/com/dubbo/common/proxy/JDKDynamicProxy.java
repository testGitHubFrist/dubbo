package com.dubbo.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/28 15:21
 * @Description: jdk动态代理java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
 */
public class JDKDynamicProxy implements InvocationHandler {


    private Object targetObject;//需要代理的目标对象

    public Object newProxy(Object targetObject) {//将目标对象传入进行代理
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);//返回代理对象
    }

    public Object invoke(Object proxy, Method method, Object[] args)//invoke方法
            throws Throwable {
        checkPopedom();//一般我们进行逻辑处理的函数比如这个地方是模拟检查权限
        Object ret = null;      // 设置方法的返回值
        ret = method.invoke(targetObject, args);       //调用invoke方法，ret存储该方法的返回值
        return ret;
    }

    private void checkPopedom() {//模拟检查权限的例子
        System.out.println(".:检查权限  checkPopedom()!");
    }


}
