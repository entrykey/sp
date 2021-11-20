package com.sp.spmain.common.bean;

public class ApiResponse {
	
	 private String status;
	 
	 private String message;
	 
	 private Object data;
	 
	 private Object error;
	 
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

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

}
