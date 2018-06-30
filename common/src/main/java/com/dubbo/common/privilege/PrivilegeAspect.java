package com.dubbo.common.privilege;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dubbo.common.constants.CommonConstants;

/**
 * aop权限控制
 * @author GaoQun
 *
 */
@Aspect
@Component
public class PrivilegeAspect {
	
    /**
     * 
     * @param jionPoint
     * @return
     */
//	@Around(value="execution(@com.dubbo.annotations.Permission * *(..))")
	public Object around(ProceedingJoinPoint jionPoint) throws Throwable {
		Logger logger = LoggerFactory.getLogger(this.getTargetClass(jionPoint));
		Long begin = new Date().getTime();
		Object result = jionPoint.proceed();
		Long end = new Date().getTime();
        Long spendTime = (end - begin)/CommonConstants.MILLON_INT;
        logger.info("权限校验耗时 time：{}:s   ******",spendTime);
		return result;
	}
	
	/**
	 * 获取目标类
	 * @param jionPoint
	 * @return
	 */
	private Class getTargetClass(ProceedingJoinPoint jionPoint){
		return jionPoint.getSignature().getClass();
	}
	
	/**
	 * 获取目标类中的方法
	 * @param jionPoint
	 * @return
	 */
	private Method getTargetMethod(ProceedingJoinPoint jionPoint){
		MethodSignature methodSignature=(MethodSignature)jionPoint;
		return methodSignature.getMethod();
	} 
	
	/**
	 * 权限校验:1、校验方法上是否有Permission 注解，如果有则优先依赖方法上注解的权限
	 *       2、校验类上是否有Permission注解，如果没有则抛异常
	 */
	private void checkPrivilege(ProceedingJoinPoint jionPoint){
		
	}
}
