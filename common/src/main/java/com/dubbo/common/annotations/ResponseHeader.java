package com.dubbo.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseHeader {

	String name() default "";
	
	String description() default "";
	
	Class<?> response() default Void.class;
	
	String responseContainer() default "";
}
