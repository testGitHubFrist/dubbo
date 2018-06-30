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

import com.dubbo.common.annotations.Permission;
import com.dubbo.common.constants.CommonConstants;

/**
 * aop权限控制
 * @author GaoQun
 *
 */
@Aspect
@Component
public class PrivilegeAspect {
	private Logger logger = LoggerFactory.getLogger(PrivilegeAspect.class);
    /**
     * 
     * @param jionPoint
     * @return
     */
	@Around(value="@annotation(com.dubbo.common.annotations.Permission)")
	public Object around(ProceedingJoinPoint jionPoint) throws Throwable {
		Long begin = new Date().getTime();
		checkPrivilege(jionPoint);
		Object result = jionPoint.proceed();
		Long end = new Date().getTime();
        Long spendTime = (end - begin)/CommonConstants.MILLON_INT;
        System.out.println("权限校验耗时 time：{}:"+spendTime+"s   ******");
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
		MethodSignature methodSignature=(MethodSignature)jionPoint.getSignature();
		return methodSignature.getMethod();
	} 
	
	/**
	 * 权限校验:1、校验方法上是否有Permission 注解，如果有则优先依赖方法上注解的权限
	 *       2、校验类上是否有Permission注解，如果没有则抛异常
	 */
	private void checkPrivilege(ProceedingJoinPoint jionPoint){
		//获取方法上的注解
		Permission methodPermission=this.getTargetMethod(jionPoint).getAnnotation(Permission.class);
		if(methodPermission!=null){
			System.out.println("方法上注解:"+methodPermission.value());
		}
		//获取类上的注解
		Permission classPermission=(Permission) this.getTargetClass(jionPoint).getAnnotation(Permission.class);
		if(classPermission!=null){
			System.out.println("类上注解:"+classPermission.value());
		}
	}
}
