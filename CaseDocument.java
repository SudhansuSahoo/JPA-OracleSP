package com.hig.oracleformsmigration.casemanagement.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CASEDOCUMENT")
public class CaseDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CDID")
	private int cdid;
	@Column(name="CASEID")
	private int caseID;
	//@Column(name="CASEID")
	@Column(name="CMDID")
	private int cmdid;
	
	
	
	/*
	 * @ManyToOne(targetEntity = CaseManagementData.class, mappedBy = "cd_id", fetch
	 * = FetchType.LAZY) private Set<CaseManagementData> CaseManagementData;
	 */
	
	public int getCmdid() {
		return cmdid;
	}
	public void setCmdid(int cmdid) {
		this.cmdid = cmdid;
	}
	
	public int getCdid() {
		return cdid;
	}
	public void setCdid(int cdid) {
		this.cdid = cdid;
	}
	public int getCaseID() {
		return caseID;
	}
	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}
	public CaseDocument(int cdid, int caseID, int cmdid) {
		super();
		this.cdid = cdid;
		this.caseID = caseID;
		this.cmdid = cmdid;
	}
	public CaseDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
