package com.sp.spmain.common.bean;

public class ApiResponse {
	
	 private String status="200";
	 
	 private String message="Success";
	 
	 private Object data;
	 
	 private Boolean errorFlag=false;
	 
	 public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Boolean getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(Boolean errorFlag) {
		this.errorFlag = errorFlag;
	}
	
	
	public ApiResponse errorset(String message) {
		ApiResponse rt = new ApiResponse();
		rt.setStatus("202");
		rt.setData(null);
		rt.setErrorFlag(true);
		rt.setMessage(message);
		return rt;
	}
}
