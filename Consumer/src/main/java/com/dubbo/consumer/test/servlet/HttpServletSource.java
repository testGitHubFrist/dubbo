//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

/**
 *
 * 功能描述: httpServlet源码学习
 *
 * @param:
 * @return:
 * @auther: zhangshanchuang
 * @date: 18/7/29 下午3:13
 */

package com.dubbo.consumer.test.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpServletSource extends GenericServlet {
    //HTTP的各种方法
    private static final long serialVersionUID = 1L;
    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_HEAD = "HEAD";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_TRACE = "TRACE";
    private static final String HEADER_IFMODSINCE = "If-Modified-Since";
    private static final String HEADER_LASTMOD = "Last-Modified";
    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");

    public HttpServletSource() {
    }


    /**
     * 被service()方法调用去处理GET请求
     * 重写此方法以支持GET请求同样也自动的支持HEAD请求
     * 一个HEAD请求就是一个GET请求，只不过HEAD请求只返回首部，不返回响应实体部分
     * 子类如果要支持GET方法，就必须要重写次方法，因为HttpServlet的默认实现是
     * 发送错误
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //返回使用的协议，protocol/majorVersion,如HTTP/1.1
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_get_not_supported");
        //由于是默认实现，根据不同的协议，直接报错
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }

    }

    /**
     * 返回的值代表当前输出响应内容的修改时间，总是返回-1，子类可重写
     * getLastModified方法是一个回调方法，由HttpServlet的service方法调用，
     * service方法可以根据返回值在响应消息中自动生成Last_Modified头字段（最后被修改的时间）
     * Servlet受到一个GET方式的请求时，HttpServlet重载的service方法在调用doGet之前，会先
     * 调用本方法，并根据返回值来决定是否调用doGet方法和在响应消息是是否生成Last_Modified字段
     * 具体规则如下：
     * 1.如果是一个负数（本方法默认实现），直接调用doGet方法
     * 2.如果是一个正数，且请求消息中没有包含If-Modified-Since请求头，或者请求头中的时间值
     *   比返回值旧时,这说明要么是第一次请求，要么是缓存过期了，service将根据返回值生成一个
     *   Last-Modified字段，并调用doGet方法
     * 3.本方法返回值是一个正数，且请求消息中包含的If-Modified-Since的时间值比返回值新或者相同，
     * 说明缓存有效,service方法将不调用doGet方法，而是返回304(Not Modified)告诉浏览器缓存仍然有效
     */
    protected long getLastModified(HttpServletRequest req) {
        return -1L;
    }


    /**
     * 没有相应实体，其他与GET方法相同，也正是通过调用doGet来完成请求
     */
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (DispatcherType.INCLUDE.equals(req.getDispatcherType())) {
//            this.doGet(req, resp);
//        } else {
//            NoBodyResponse response = new NoBodyResponse(resp);
//            this.doGet(req, response);
//            response.setContentLength();
//        }

    }
    /**
     * 也是被service方法调用，默认实现是报错,参考doGet方法
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_post_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }

    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_put_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }

    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_delete_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }

    }

    private static Method[] getAllDeclaredMethods(Class<?> c) {
        if (c.equals(HttpServletSource.class)) {
            return null;
        } else {
            Method[] parentMethods = getAllDeclaredMethods(c.getSuperclass());
            Method[] thisMethods = c.getDeclaredMethods();
            if (parentMethods != null && parentMethods.length > 0) {
                Method[] allMethods = new Method[parentMethods.length + thisMethods.length];
                System.arraycopy(parentMethods, 0, allMethods, 0, parentMethods.length);
                System.arraycopy(thisMethods, 0, allMethods, parentMethods.length, thisMethods.length);
                thisMethods = allMethods;
            }

            return thisMethods;
        }
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Method[] methods = getAllDeclaredMethods(this.getClass());
        boolean ALLOW_GET = false;
        boolean ALLOW_HEAD = false;
        boolean ALLOW_POST = false;
        boolean ALLOW_PUT = false;
        boolean ALLOW_DELETE = false;
        boolean ALLOW_TRACE = true;
        boolean ALLOW_OPTIONS = true;

        for(int i = 0; i < methods.length; ++i) {
            Method m = methods[i];
            if (m.getName().equals("doGet")) {
                ALLOW_GET = true;
                ALLOW_HEAD = true;
            }

            if (m.getName().equals("doPost")) {
                ALLOW_POST = true;
            }

            if (m.getName().equals("doPut")) {
                ALLOW_PUT = true;
            }

            if (m.getName().equals("doDelete")) {
                ALLOW_DELETE = true;
            }
        }

        String allow = null;
        if (ALLOW_GET) {
            allow = "GET";
        }

        if (ALLOW_HEAD) {
            if (allow == null) {
                allow = "HEAD";
            } else {
                allow = allow + ", HEAD";
            }
        }

        if (ALLOW_POST) {
            if (allow == null) {
                allow = "POST";
            } else {
                allow = allow + ", POST";
            }
        }

        if (ALLOW_PUT) {
            if (allow == null) {
                allow = "PUT";
            } else {
                allow = allow + ", PUT";
            }
        }

        if (ALLOW_DELETE) {
            if (allow == null) {
                allow = "DELETE";
            } else {
                allow = allow + ", DELETE";
            }
        }

        if (ALLOW_TRACE) {
            if (allow == null) {
                allow = "TRACE";
            } else {
                allow = allow + ", TRACE";
            }
        }

        if (ALLOW_OPTIONS) {
            if (allow == null) {
                allow = "OPTIONS";
            } else {
                allow = allow + ", OPTIONS";
            }
        }

        resp.setHeader("Allow", allow);
    }

    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String CRLF = "\r\n";
        StringBuilder buffer = (new StringBuilder("TRACE ")).append(req.getRequestURI()).append(" ").append(req.getProtocol());
        Enumeration reqHeaderEnum = req.getHeaderNames();

        while(reqHeaderEnum.hasMoreElements()) {
            String headerName = (String)reqHeaderEnum.nextElement();
            buffer.append(CRLF).append(headerName).append(": ").append(req.getHeader(headerName));
        }

        buffer.append(CRLF);
        int responseLength = buffer.length();
        resp.setContentType("message/http");
        resp.setContentLength(responseLength);
        ServletOutputStream out = resp.getOutputStream();
        out.print(buffer.toString());
        out.close();
    }

    /**
     * 处理标准的HTTP请求，此方法把具体的请求转发到相应的doXXX方法上
     * 被service(ServletRequest，ServletResponse)调用
     * 没有理由重写此方法
     */

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //返回HTTP的请求方式，如GET,POST,HEAD
        String method = req.getMethod();


        /**
         * 如果是GET方式
         * 1.首先通过getLastModified(req)获得修改时间
         *  i.如果修改时间==-1，不管请求是怎样的，直接调用doGet
         *  ii.如果不是-1，则需要获取请求中的If-Modified_Since的值，保存到ifModifiedSince变量中
         *     如果请求头中没有If-Modified-Since字段，则ifModifiedSince=-1,通过比较lastModified
         *     和ifModifiedSince的值来判断缓存是否过期:
         *     如果lastModified代表的日期比ifModifiedSince代表的日期新时，则说明缓存失效了，
         *     比如lastModified代表9月1号修改的，ifModifiedSince为8月1号，
         *     意思是如果自8月1号没有修改过的话,则可以使用缓存，很明显已经修改过了，
         *     所以不能使用缓存,这个时候要调用doGet方法响应，同时在相应头设置Last-Modified的值。
         *     如果lastModified代表的时间比ifModifiedSince旧时，也就是没有修改过，
         *     则返回304（Not Modified）告诉浏览器，直接使用缓存。
         * 2.判断是何种方式，调用具体的doXXX方法
         *
         */
        long lastModified;
        if (method.equals("GET")) {
            lastModified = this.getLastModified(req);
            if (lastModified == -1L) {
                this.doGet(req, resp);
            } else {
                long ifModifiedSince;
                try {
                    ifModifiedSince = req.getDateHeader("If-Modified-Since");
                } catch (IllegalArgumentException var9) {
                    ifModifiedSince = -1L;
                }

                if (ifModifiedSince < lastModified / 1000L * 1000L) {
                    this.maybeSetLastModified(resp, lastModified);
                    this.doGet(req, resp);
                } else {
                    resp.setStatus(304);
                }
            }
        } else if (method.equals("HEAD")) {
            lastModified = this.getLastModified(req);
            this.maybeSetLastModified(resp, lastModified);
            this.doHead(req, resp);
        } else if (method.equals("POST")) {
            this.doPost(req, resp);
        } else if (method.equals("PUT")) {
            this.doPut(req, resp);
        } else if (method.equals("DELETE")) {
            this.doDelete(req, resp);
        } else if (method.equals("OPTIONS")) {
            this.doOptions(req, resp);
        } else if (method.equals("TRACE")) {
            this.doTrace(req, resp);
        } else {
            String errMsg = lStrings.getString("http.method_not_implemented");
            Object[] errArgs = new Object[]{method};
            errMsg = MessageFormat.format(errMsg, errArgs);
            resp.sendError(501, errMsg);
        }

    }

    private void maybeSetLastModified(HttpServletResponse resp, long lastModified) {
        if (!resp.containsHeader("Last-Modified")) {
            if (lastModified >= 0L) {
                resp.setDateHeader("Last-Modified", lastModified);
            }

        }
    }


    /**
     * 被Servlet容器调用，完成请求
     * 把请求转发到具体的方法上，通过调用重载的service(HttpServletRequest,HttpServletResponse)
     * 完成这个方法做的事情就是把request和response转换成HttpServerRequest,HttpServletResponse,
     * 具体的转发工作由重载的service方法完成
     */
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;
        try {
            request = (HttpServletRequest)req;
            response = (HttpServletResponse)res;
        } catch (ClassCastException var6) {
            throw new ServletException("non-HTTP request or response");
        }

        this.service(request, response);
    }
}
