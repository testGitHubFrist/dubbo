package com.dubbo.aop.log;

import java.util.Map;

/**
 * Api上下文.
 */
public class ApiContext {

	private ThreadLocal<Map<String, Object>> localMap;
	private static ApiContext instance = new ApiContext();

	private ApiContext() {
		localMap = new ThreadLocal<Map<String, Object>>();
	}

	public static ApiContext getInstance() {
		return instance;
	}

	public Map<String, Object> getContext() {
		return localMap.get();
	}

	void add(Map<String, Object> map) {
		localMap.set(map);
	}

	void remove() {
		localMap.remove();
	}

	public static class ApiContextKey {
		/**
		 * 上下文唯一标识
		 */
		public static final String CONTEXT_ID = "X-Api-ContextId";
		/**
		 * Api调用层级
		 */
		public static final String CONTEXT_LAYER = "X-Api-ContextLayer";
		/**
		 * 上级Api
		 */
		public static final String CONTEXT_FATHER = "X-Api-Father";
		/**
		 * Api服务类名
		 */
		public static final String API_SERVICE_NAME = "ServiceName";
		/**
		 * Api服务方法名
		 */
		public static final String API_METHOD_NAME = "MethodName";
		/**
		 * Api调用操作人
		 */
		public static final String API_OPERATOR = "Operator";
	}
}
