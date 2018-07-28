package com.dubbo.common.proxy;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/28 15:28
 * @Description:
 */
public class test {

    public static void main(String[] args) {

        UserManager userManager = (UserManager) new CglibProxy()
                .createProxyObject(new UserManagerImpl());
        System.out.println("-----------CGLibProxy-------------");
        userManager.addUser("tom", "root");
        System.out.println("-----------JDKProxy-------------");
        JDKDynamicProxy jdkPrpxy = new JDKDynamicProxy();
        UserManager userManagerJDK = (UserManager) jdkPrpxy
                .newProxy(new UserManagerImpl());
        userManagerJDK.addUser("tom", "root");
    }

}
