package com.dubbo.common.aop.log;

import java.util.Date;

/**
 * 日志模板
 * @author GaoQun
 *
 */
public class ActionLog {

	private boolean flag=false;
	
	private int id;
	
	private String uniqueID;
	
	private String sessionID;
	
	private String contextID;
	
	private String executeID;
	//是否异常，异常=1，正常=0
	private int  logType;
	
	private String serviceName;
	
	private String methodName;
	
	private String fromUrl;
	
	private String referUrl;
	
	private String fromSystem;
	
	private String clentIP;
	
	private String potocolServerIP;
	
	private String appServerIP;
	
	private String exceptionMessage;
	
	private String detail;
	
	private float excuteTimeSpan;
	
	private Date logTime;
	
	private String extend1;
	
	private String extend2;
	
	private Date createTime;
	
	private String productLine;
	
	private int responseCode;
	
	private String channel;
	
	private long methodStartTime;
	
	private String parameters;
	
	private String result;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public String getExecuteID() {
		return executeID;
	}

	public void setExecuteID(String executeID) {
		this.executeID = executeID;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
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

	public String getFromUrl() {
		return fromUrl;
	}

	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}

	public String getReferUrl() {
		return referUrl;
	}

	public void setReferUrl(String referUrl) {
		this.referUrl = referUrl;
	}

	public String getFromSystem() {
		return fromSystem;
	}

	public void setFromSystem(String fromSystem) {
		this.fromSystem = fromSystem;
	}

	public String getClentIP() {
		return clentIP;
	}

	public void setClentIP(String clentIP) {
		this.clentIP = clentIP;
	}

	public String getPotocolServerIP() {
		return potocolServerIP;
	}

	public void setPotocolServerIP(String potocolServerIP) {
		this.potocolServerIP = potocolServerIP;
	}

	public String getAppServerIP() {
		return appServerIP;
	}

	public void setAppServerIP(String appServerIP) {
		this.appServerIP = appServerIP;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public float getExcuteTimeSpan() {
		return excuteTimeSpan;
	}

	public void setExcuteTimeSpan(float excuteTimeSpan) {
		this.excuteTimeSpan = excuteTimeSpan;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public long getMethodStartTime() {
		return methodStartTime;
	}

	public void setMethodStartTime(long methodStartTime) {
		this.methodStartTime = methodStartTime;
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

	@Override
	public String toString() {
		return "ActionLog [flag=" + flag + ", id=" + id + ", uniqueID="
				+ uniqueID + ", sessionID=" + sessionID + ", contextID="
				+ contextID + ", executeID=" + executeID + ", logType="
				+ logType + ", serviceName=" + serviceName + ", methodName="
				+ methodName + ", fromUrl=" + fromUrl + ", referUrl="
				+ referUrl + ", fromSystem=" + fromSystem + ", clentIP="
				+ clentIP + ", potocolServerIP=" + potocolServerIP
				+ ", appServerIP=" + appServerIP + ", exceptionMessage="
				+ exceptionMessage + ", detail=" + detail + ", excuteTimeSpan="
				+ excuteTimeSpan + ", logTime=" + logTime + ", extend1="
				+ extend1 + ", extend2=" + extend2 + ", createTime="
				+ createTime + ", productLine=" + productLine
				+ ", responseCode=" + responseCode + ", channel=" + channel
				+ ", methodStartTime=" + methodStartTime + ", parameters="
				+ parameters + ", result=" + result + "]";
	}
	
	
}
