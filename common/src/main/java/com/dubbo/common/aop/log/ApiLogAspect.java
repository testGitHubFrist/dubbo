package com.dubbo.common.aop.log;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubbo.common.util.BusinessException;
import com.dubbo.common.util.OSUtils;

/**
 * @author GaoQun
 * 利用aop实现日志统一输出
 */
public class ApiLogAspect implements MethodInterceptor {

    private static final Logger actionLogger = LoggerFactory.getLogger(ApiLogAspect.class);

    //统一替换系统异常术语
    private String unifiedSystemErrorDescription;

    public String getUnifiedSystemErrorDescription() {
        return unifiedSystemErrorDescription;
    }


    public void setUnifiedSystemErrorDescription(
            String unifiedSystemErrorDescription) {
        this.unifiedSystemErrorDescription = unifiedSystemErrorDescription;
    }

    /**
     * 功能描述: 日志拦截方法
     *
     * @param:
     * @return:
     * @auther: zhangshanchuang
     * @date: 18/6/25 上午10:18
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {

//        ActionLogWrapper logWrapper = new ActionLogWrapper();
        //日志上下文
//        logWrapper.setContentId(ApiContext.getInstance().getContext().get(ApiContext.ApiContextKey.CONTEXT_ID).toString());
        Method method = invocation.getMethod();
        //
//        logWrapper.setMethodName(method.getName());
        ////方法定义所在的类
//        logWrapper.setServiceName(method.getDeclaringClass().getName());
//        ApiContext.getInstance().getContext().put(ApiContext.ApiContextKey.API_SERVICE_NAME, logWrapper.getServiceName());
//        ApiContext.getInstance().getContext().put(ApiContext.ApiContextKey.API_METHOD_NAME, logWrapper.getMethodName());
        try {
            //执行target方法
            Object result = invocation.proceed();
            // 2.after process: set sys response info
            if (result instanceof AbstractResponse) {
                //response 赋值
                AbstractResponse response = (AbstractResponse) result;
                //设置IP等
//                setResponseSystemInfo(response, logWrapper);
//                logWrapper.setResponseCode(response.getRetcode());
                //如果返回值不为0时，纪录入参与出参
                if (response.getRetcode() != 0) {
                    //纪录入参
                    if (invocation.getArguments().length > 0) {
//                        logWrapper.setParameters(JSON.json(invocation.getArguments()[0]));
                    }
                    //纪录返回值
//                    logWrapper.setResult(JSON.json(response));
                }
                // replace return desc
                if (response.getRetcode() < 0 && StringUtils.isNotBlank(this.unifiedSystemErrorDescription)) {
                    response.setRetdesc(this.unifiedSystemErrorDescription);
                }
            }
            return result;
        } catch (Throwable t) {
//            return handlerError(t, method.getReturnType(), logWrapper, invocation.getArguments());
        } finally {
//            String clientIp = SpringContextUtil.getRequest().getRemoteAddr();
//            String protocolIp = SpringContextUtil.getRequest().getLocalAddr();

//            logWrapper.setClientIp(clientIp);
//            logWrapper.setProtocolServerIp(protocolIp);

//            ActionLog originalEntity = logWrapper.getOriginalEntity();
//            actionLogger.info(originalEntity.toString());
        }
        return method;
    }

    private void setResponseSystemInfo(AbstractResponse response, ActionLogWrapper logWrapper) {
        response.setServerIp(OSUtils.getLocalIP());
        response.setServerTicks(System.currentTimeMillis() - logWrapper.getStart());
    }

    private Object handlerError(Throwable t, Class<?> returnType, ActionLogWrapper logWrapper, Object[] arguments) throws Throwable {
        if (AbstractResponse.class.isAssignableFrom(returnType)) {
            AbstractResponse response = (AbstractResponse) returnType.newInstance();
            if (t instanceof BusinessException) {
                BusinessException businessException = (BusinessException) t;
                response.setRetcode(businessException.getResponseCode());
                response.setRetdesc(businessException.getErrorMessage());
                logWrapper.setResponseCode(response.getRetcode());
            } else {
                response.setRetcode(-1); // System error code
                if (StringUtils.isNotBlank(this.unifiedSystemErrorDescription)) {
                    response.setRetdesc(this.unifiedSystemErrorDescription);
                } else {
                    response.setRetdesc(t.toString());
                }
                logWrapper.setException(t);
            }
            setResponseSystemInfo(response, logWrapper);
//            if (arguments.length > 0) {
//                logWrapper.setParameters(JSON.json(arguments[0]));
//            }
//            logWrapper.setResult(JSON.json(response));
            return response;
        } else {
            logWrapper.setException(t);
            throw t;
        }
    }

}
