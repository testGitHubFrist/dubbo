package com.dubbo.annotations.aop.aopLog;


import com.dubbo.annotations.ApiModelProperty;

/**
 * 服务响应抽象类.
 * response 响应模版
 */
public abstract class AbstractResponse<T> {
	@ApiModelProperty("业务结果对象")
	private T body;
	@ApiModelProperty("状态码：0正常，-1系统异常，>0业务异常")
	private int retcode;
	@ApiModelProperty("状态码不为0时的异常描述信息")
	private String retdesc;
	@ApiModelProperty("服务器ip")
	private String serverIp;
	@ApiModelProperty("服务器处理时长，单位ms")
	private long serverTicks;

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public int getRetcode() {
		return retcode;
	}

	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}

	public String getRetdesc() {
		return retdesc;
	}

	public void setRetdesc(String retdesc) {
		this.retdesc = retdesc;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public long getServerTicks() {
		return serverTicks;
	}

	public void setServerTicks(long serverTicks) {
		this.serverTicks = serverTicks;
	}
}
