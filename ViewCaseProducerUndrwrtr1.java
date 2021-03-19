package com.hig.oracleformsmigration.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class ViewCaseProducerUndrwrtr1 {
	
	
	private String vndrId;
	
	
	private String producer;
	
	
	private String undrwrtr;

	public String getVndrId() {
		return vndrId;
	}

	public void setVndrId(String vndrId) {
		this.vndrId = vndrId;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getUndrwrtr() {
		return undrwrtr;
	}

	public void setUndrwrtr(String undrwrtr) {
		this.undrwrtr = undrwrtr;
	}

	public ViewCaseProducerUndrwrtr1(String vndrId, String producer, String undrwrtr) {
		super();
		this.vndrId = vndrId;
		this.producer = producer;
		this.undrwrtr = undrwrtr;
	}

	public ViewCaseProducerUndrwrtr1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
