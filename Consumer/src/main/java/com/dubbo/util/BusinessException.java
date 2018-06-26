package com.dubbo.util;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2154857670489507968L;

	private String errorMessage;
	private int responseCode;
	private Exception exception;
	private Object errorObject;

	/**
	 * 构造器
	 *
	 * @param message 错误信息
	 * @param code    错误代码
	 * @param ex      异常
	 */
	public BusinessException(String message, int code, Exception ex) {
		this(message, code, ex, null);
	}

	/**
	 * bs.
	 * @param message     message
	 * @param code        code
	 * @param ex          ex
	 * @param errorObject err
	 */
	public BusinessException(String message, int code, Exception ex, Object errorObject) {
		super(message, ex);
		this.errorMessage = message;
		this.responseCode = code;
		this.exception = ex;
		this.errorObject = errorObject;
	}

	/**
	 * Getter for property 'errorMessage'.
	 *
	 * @return Value for property 'errorMessage'.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Setter for property 'errorMessage'.
	 *
	 * @param errorMessage Value to set for property 'errorMessage'.
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Getter for property 'responseCode'.
	 *
	 * @return Value for property 'responseCode'.
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * Setter for property 'responseCode'.
	 *
	 * @param responseCode Value to set for property 'responseCode'.
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Getter for property 'exception'.
	 *
	 * @return Value for property 'exception'.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Setter for property 'exception'.
	 *
	 * @param exception Value to set for property 'exception'.
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

	public Object getErrorObject() {
		return errorObject;
	}

	public void setErrorObject(Object errorObject) {
		this.errorObject = errorObject;
	}

}
