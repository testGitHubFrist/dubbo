package com.dubbo.common.aop.log;

import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.dubbo.common.util.OSUtils;
import com.dubbo.common.util.PropertiesHelper;

/**
 * 日志包装类
 *
 * @author GaoQun
 */
public class ActionLogWrapper {

    private static String defaultProductLine = PropertiesHelper.getEnvProperties("productline", "productline").toString();

    private static String defaultProductService = PropertiesHelper.getEnvProperties("servicename", "productline").toString();

    private String serviceName;

    private String methodName;

    private String productLine;

    private Throwable exception = null;

    private int responseCode;

    private String clientIp;

    private String protocolServerIp;

    private String fromSystem;

    private long start;

    private String parameters;

    private String result;

    private String contentId;

    public static String getDefaultProductLine() {
        return defaultProductLine;
    }

    public static void setDefaultProductLine(String defaultProductLine) {
        ActionLogWrapper.defaultProductLine = defaultProductLine;
    }

    public static String getDefaultProductService() {
        return defaultProductService;
    }

    public static void setDefaultProductService(String defaultProductService) {
        ActionLogWrapper.defaultProductService = defaultProductService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getProtocolServerIp() {
        return protocolServerIp;
    }

    public void setProtocolServerIp(String protocolServerIp) {
        this.protocolServerIp = protocolServerIp;
    }

    public String getFromSystem() {
        return fromSystem;
    }

    public void setFromSystem(String fromSystem) {
        this.fromSystem = fromSystem;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public ActionLogWrapper() {
        this.start = System.currentTimeMillis();
    }

    public ActionLog getOriginalEntity() {
        ActionLog actLogEntity = new ActionLog();
        if (exception != null) {
            String exceptionMessage = replaceInvalidChar(exception.getClass().getName() + ":" + exception.getMessage());
            if (exceptionMessage != null && exceptionMessage.length() > 6000) {
                exceptionMessage = exceptionMessage.substring(0, 5999);
            }
            actLogEntity.setExceptionMessage(exceptionMessage);
            String detail = replaceInvalidChar(ExceptionUtils.getStackTrace(exception));
            if (detail != null && detail.length() > 6000) {
                detail = detail.substring(0,5999);
            }
            actLogEntity.setDetail(detail);
        }
        actLogEntity.setContextID(contentId);
        actLogEntity.setServiceName(serviceName);
        actLogEntity.setMethodName(methodName);
        actLogEntity.setExcuteTimeSpan(System.currentTimeMillis() - start);
        actLogEntity.setAppServerIP(OSUtils.linuxLocalName());
        actLogEntity.setLogTime(new Date());
        actLogEntity.setCreateTime(new Date());
        actLogEntity.setResponseCode(responseCode);
        actLogEntity.setClentIP(clientIp);
        actLogEntity.setPotocolServerIP(protocolServerIp);
        actLogEntity.setFromSystem(fromSystem);
        actLogEntity.setParameters(parameters);
        actLogEntity.setResult(result);
        return actLogEntity;
    }

    private String replaceInvalidChar(String s) {
        return s == null ? "null" : s.replace("\t", "").replace("\n", "").replace("\r", "");
    }


}
