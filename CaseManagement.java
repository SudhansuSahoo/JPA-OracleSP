package com.hig.oracleformsmigration.casemanagement.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/*@Getter
@Setter*/
public class CaseManagement {
	
	private String caseID;

	
	private List<Cases> cases;
	

	public List<Cases> getCases() {
		return cases;
	}

	public void setCases(List<Cases> cases) {
		this.cases = cases;
	}

	public String getCaseID() {
		return caseID;
	}

	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}

	public String getServiceRepID() {
		return serviceRepID;
	}

	public void setServiceRepID(String serviceRepID) {
		this.serviceRepID = serviceRepID;
	}

	public String getSalesRepID() {
		return salesRepID;
	}

	public void setSalesRepID(String salesRepID) {
		this.salesRepID = salesRepID;
	}

	public String getProducerID() {
		return producerID;
	}

	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}

	public String getUnderwriterID() {
		return underwriterID;
	}

	public void setUnderwriterID(String underwriterID) {
		this.underwriterID = underwriterID;
	}

	public String getNewSalesOfficeID() {
		return newSalesOfficeID;
	}

	public void setNewSalesOfficeID(String newSalesOfficeID) {
		this.newSalesOfficeID = newSalesOfficeID;
	}

	public String getNewProducerID() {
		return newProducerID;
	}

	public void setNewProducerID(String newProducerID) {
		this.newProducerID = newProducerID;
	}

	public String getNewServiceRepID() {
		return newServiceRepID;
	}

	public void setNewServiceRepID(String newServiceRepID) {
		this.newServiceRepID = newServiceRepID;
	}

	public String getNewSalesRepID() {
		return newSalesRepID;
	}

	public void setNewSalesRepID(String newSalesRepID) {
		this.newSalesRepID = newSalesRepID;
	}

	public String getNewUndewriterID() {
		return newUndewriterID;
	}

	public void setNewUndewriterID(String newUndewriterID) {
		this.newUndewriterID = newUndewriterID;
	}

	

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}


	private String formType;
	
	private String serviceRepID;
	
	private String salesRepID;

	private String producerID;
	
	private String underwriterID;
	
	private String newSalesOfficeID;
	
	private String newProducerID;

	private String newServiceRepID;
	
	private String newSalesRepID;
	
	private String newUndewriterID;
	
	private String currentsalesrepid;
	
	private String userId;


	public String getCurrentsalesrepid() {
		return currentsalesrepid;
	}

	public void setCurrentsalesrepid(String currentsalesrepid) {
		this.currentsalesrepid = currentsalesrepid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public CaseManagement(String caseID, List<Cases> cases, String formType, String serviceRepID, String salesRepID,
			String producerID, String underwriterID, String newSalesOfficeID, String newProducerID,
			String newServiceRepID, String newSalesRepID, String newUndewriterID, String currentsalesrepid,
			String userId) {
		super();
		this.caseID = caseID;
		this.cases = cases;
		this.formType = formType;
		this.serviceRepID = serviceRepID;
		this.salesRepID = salesRepID;
		this.producerID = producerID;
		this.underwriterID = underwriterID;
		this.newSalesOfficeID = newSalesOfficeID;
		this.newProducerID = newProducerID;
		this.newServiceRepID = newServiceRepID;
		this.newSalesRepID = newSalesRepID;
		this.newUndewriterID = newUndewriterID;
		this.currentsalesrepid = currentsalesrepid;
		this.userId = userId;
	}

	public CaseManagement() {
		super();
		// TODO Auto-generated constructor stub
	}





	

	





	
	
	
	
	
}