package com.dubbo.consumer.test.aop;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/22 11:27
 * @Description: aop探讨
 */
public class DaoImpl implements Dao {

    public void add() {
        System.out.println("[DaoImpl] add()");
    }

    public void delete() {
        System.out.println("[DaoImpl] delete");
    }
}
