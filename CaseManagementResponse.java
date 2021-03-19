package com.hig.oracleformsmigration.lossprocessing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CaseManagementResponse {
	
	

	public CaseManagementResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaseManagementResponse(String message, String statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	private String message;
	private String statusCode;
}
