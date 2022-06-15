package com.medicine.customexception;

public class ControllerException {
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
	public ControllerException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	
}
