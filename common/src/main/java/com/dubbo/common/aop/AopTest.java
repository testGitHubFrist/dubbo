package com.dubbo.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//切面
public class AopTest {
	// 切入点注解
	@Pointcut("execution(* com.dubbo.consumer..*.*(..))")
	public void queryList() {
	}

	// 目标类方法执行前执行该方法
	@Before(value = "queryList()")
	public void before() {
		System.out.println("目标类方法执行前执行该方法........");
	}

	@AfterReturning(value = "queryList()")
	public void afterReturn() {
		System.out.println("方法正常结束后执行该输出");
	}

	@After(value = "queryList()")
	public void after() {
		System.out.println("最终通知,方法无论是否发生异常,都会执行该输出");
	}

	@AfterThrowing(value = "queryList()", throwing = "e")
	public void afterThrow(Exception e) {
		System.out.println("如果方法执行发生异常,执行该输出" + e);
	}

	@Around(value = "queryList()")
	public Object around(ProceedingJoinPoint pjp) {
		Object result = null;
		System.out.println("环绕通知---前置通知");
		try {
			Object[] params = pjp.getArgs();// 获取方法参数
			if (null != params || params.length > 0) {
				for (Object object : params) {
					System.out.println(object.toString());
				}
			}
			System.out.println("方法签名:" + pjp.getSignature());// 获取方法签名
			System.out.println("目标类" + pjp.getTarget());// 目标类
			result = pjp.proceed();// 执行目标对象的方法
			System.out.println("环绕通知---后置通知");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("环绕通知---最终通知");
		}
		return result;

	}

}