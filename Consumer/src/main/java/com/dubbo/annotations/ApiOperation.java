package com.dubbo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * api日志注解
 *  default常用于接口中，从它的中文意思行来看，大概能猜个差不多，我们本来写Java接口的时候，是不能有方法体的函数，就类似于C++中的虚函数，default关键字在接口中修饰方法时，方法可以有方法体，来看一个例子。
 *  ，default关键字可以让接口中的方法可以有默认的函数体，当一个类实现这个接口时，可以不用去实现这个方法，当然，这个类若实现这个方法，就等于子类覆盖了这个方法，最终运行结果符合Java多态特性。
 * @author GaoQun
 *
 */
//@Target –注解用于什么地方
//● ElementType.CONSTRUCTOR:用于描述构造器
//● ElementType.FIELD:成员变量、对象、属性（包括enum实例）
//● ElementType.LOCAL_VARIABLE:用于描述局部变量
//● ElementType.METHOD:用于描述方法
//● ElementType.PACKAGE:用于描述包
//● ElementType.PARAMETER:用于描述参数
//● ElementType.TYPE:用于描述类、接口(包括注解类型) 或enum声明
@Target({ ElementType.METHOD })
// @Retention –什么时候使用该注解 
//1.）@Retention– 定义该注解的生命周期
//●   RetentionPolicy.SOURCE : 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。
//●   RetentionPolicy.CLASS : 在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式
//●   RetentionPolicy.RUNTIME : 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。我们自定义的注解通常使用这种方式。
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiOperation {
	String value();

	String notes() default "";

	String[] tags() default { "" };
	
	Class<?> response() default Void.class;

	String responseContainer() default "";
	
	String responseReference() default "";
	
	String httpMethod() default "";
	
	String nickname() default "";
	
	String produces() default "";
	
	String consumes() default "";
	
	String protocols() default "";
	
	ResponseHeader[] responseHeader() default {@ResponseHeader(
		name="",
		response=Void.class
 )};
	 int code() default 200;
}
