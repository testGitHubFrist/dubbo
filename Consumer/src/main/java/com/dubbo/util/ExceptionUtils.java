package com.dubbo.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;


public class ExceptionUtils {

	static final String WRAPPED_MARKER="[wrapped]";
	private static final String[] CAUSE_METHOD_NAMES=new String[]{"getCause","getNextException","getTargetExeption","getException","getSourceException","getRootCause","getCauseByException","getNested","getLinkedException","getNestedException","getLinkedCause","getThrowable"};
	
	public ExceptionUtils(){
		
	}
	
	@Deprecated
	public static String[] getDefaultCauseMethodNames(){
		return ArrayUtils.clone(CAUSE_METHOD_NAMES);
	}
	
	public static Throwable getCasue(Throwable throwable){
		return getCause(throwable,CAUSE_METHOD_NAMES);
	}

	private static Throwable getCause(Throwable throwable,String[] methodNames) {
		if(throwable==null){
			return null;
		}else{
			if(methodNames==null){
				methodNames=CAUSE_METHOD_NAMES;
			}
			String[] arr$=methodNames;
			int len$=methodNames.length;
			for (int i$ = 0; i$ < len$; ++i$) {
				String methodName = arr$[i$];
				if(methodName!=null){
					Throwable cause=getCauseUsingMethodName(throwable,methodName);
					if(cause!=null){
						return cause;
					}
				}
			}
		}
		return null;
	}

	private static Throwable getCauseUsingMethodName(Throwable throwable,String methodName) {
		Method method=null;
		try {
			method=throwable.getClass().getMethod(methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口。如果是则返回 true；否则返回 false。如果该 Class 表示一个基本类型，且指定的 Class 参数正是该 Class 对象，则该方法返回 true；否则返回 false。
		if(method!=null &&Throwable.class.isAssignableFrom(method.getReturnType()) ){
			try {
				return (Throwable) method.invoke(throwable);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Throwable getRootCasue(Throwable throwable){
		List<Throwable> list=getThrowableList(throwable);
		return list.size()<2 ? null :list.get(list.size()-1);
	}

	public static List<Throwable> getThrowableList(Throwable throwable) {
		ArrayList list;
		for (list=new ArrayList(); throwable!=null && !list.contains(throwable);throwable=getCasue(throwable)) {
			list.add(throwable);
		}
		return list;
	}
	
	public static int getThrowableCount(Throwable throwable){
		return getThrowableList(throwable).size();
	}
	
	public static Throwable[] getThowables(Throwable throwable){
		List<Throwable> list=getThrowableList(throwable);
		return list.toArray(new Throwable[list.size()]);
	}

}
