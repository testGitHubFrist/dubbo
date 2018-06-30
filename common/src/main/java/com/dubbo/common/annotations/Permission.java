package com.dubbo.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  ElementType.TYPE//类，接口（包括注解），枚举
 * @author GaoQun
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

	//权限名称
	String value() default "";
	
	String operation() default "";
}
