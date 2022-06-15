package com.medicine.customexception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BusinessException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public BusinessException() {
		
	}
	
	
	
}
