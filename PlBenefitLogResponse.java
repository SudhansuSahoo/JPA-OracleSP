package com.hig.oracleformsmigration.lossprocessing.model;

public class PlBenefitLogResponse {
	
	private String plogid;
	private String errorcode;
	private String sage;
	public String getPlogid() {
		return plogid;
	}
	public void setPlogid(String plogid) {
		this.plogid = plogid;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getSage() {
		return sage;
	}
	public void setSage(String sage) {
		this.sage = sage;
	}
	public PlBenefitLogResponse(String plogid, String errorcode, String sage) {
		super();
		this.plogid = plogid;
		this.errorcode = errorcode;
		this.sage = sage;
	}
	public PlBenefitLogResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
