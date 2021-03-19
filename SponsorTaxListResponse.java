package com.hig.oracleformsmigration.lossprocessing.model;

import java.util.List;

public class SponsorTaxListResponse {
	
	private List<String> desription;
	private String errorCode;
	private String errorMessage;
	
	public List<String> getDesription() {
		return desription;
	}
	public void setDesription(List<String> desription) {
		this.desription = desription;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public SponsorTaxListResponse(List<String> desription, String errorCode, String errorMessage) {
		super();
		this.desription = desription;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public SponsorTaxListResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
