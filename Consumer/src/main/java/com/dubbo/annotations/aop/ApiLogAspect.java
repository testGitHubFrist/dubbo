package com.dubbo.annotations.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

/**
 * 
 * @author GaoQun
 * 利用aop实现日志统一输出
 */
public class ApiLogAspect implements MethodInterceptor {

	private static final Logger actionLogger=Logger.getLogger(ApiLogAspect.class);

	//统一替换系统异常术语
	private String unifiedSystemErrorDescription;
	
	public String getUnifiedSystemErrorDescription() {
		return unifiedSystemErrorDescription;
	}


	public void setUnifiedSystemErrorDescription(
			String unifiedSystemErrorDescription) {
		this.unifiedSystemErrorDescription = unifiedSystemErrorDescription;
	}

	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
}
