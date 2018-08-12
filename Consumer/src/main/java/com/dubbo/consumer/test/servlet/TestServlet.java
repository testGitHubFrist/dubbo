package com.dubbo.consumer.test.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/8/10 23:22
 * @Description:
 */
public class TestServlet implements Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {
        //容器启动时执行

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //<url-pattern>/</url-pattern> 拦截到时执行

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
