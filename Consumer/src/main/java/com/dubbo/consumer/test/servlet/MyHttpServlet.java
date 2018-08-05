package com.dubbo.consumer.test.servlet;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/29 15:32
 * @Description: 实现Servlet
 */
public class MyHttpServlet extends HttpServlet {
    private static final Properties defaultStrategies;
    public static void main(String[] args) {
        System.out.println(defaultStrategies.getProperty(WebApplicationContext.class.getName()));
    }

    static {
        try {
            ClassPathResource resource = new ClassPathResource("ContextLoader.properties", ContextLoader.class);
            defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException var1) {
            throw new IllegalStateException("Could not load 'ContextLoader.properties': " + var1.getMessage());
        }

    }

}
