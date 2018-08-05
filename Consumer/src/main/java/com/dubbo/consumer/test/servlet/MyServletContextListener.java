package com.dubbo.consumer.test.servlet;

import com.alibaba.dubbo.common.json.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/28 18:26
 * @Description: 测试ServletContextListener
 * 使用ServletContextListener接口，开发者能够在为客户端请求提供服务之前向ServletContext中添加任意的对象。这个对象在ServletContext启动的时候被初始化
 * ，然后在ServletContext整个运行期间都是可见的。
 * <p>
 * ServletContextListener实现，目标是在系统启动时添加自定义的属性，以便于在全局范围内可以随时调用。系统启动的时候会调用ServletContextListener实现类的
 * contextInitialized方法
 */
public class MyServletContextListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);

    private ServletContext context = null;


    //当Servlet 容器启动或终止Web 应用时，会触发ServletContextEvent 事件，该事件由 ServletContextListener 来处理。在 ServletContextListener 接口中定义了处理ServletContextEvent 事件的两个方法。
    //l  contextInitialized(ServletContextEvent sce) ：当Servlet 容器启动Web 应用时调用该方法。
    public void contextInitialized(ServletContextEvent servletContextEvent) {


        this.context = servletContextEvent.getServletContext();
        //可以实现自己的逻辑并将结果记录在属性中
        context.setAttribute("myData", "this is myData");
        //一旦web应用启动的时候，我们就能在任意的Servlet或者jsp中通过 String myDate＝getServletContext.getAttribute("myDate"); 获取
        logger.info((String)context.getAttribute("myData"));

    }

    //该方法在ServletContext将要关闭时调用
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.context = null;

    }
}
