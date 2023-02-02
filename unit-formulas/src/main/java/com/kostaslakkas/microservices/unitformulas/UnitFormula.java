package com.kostaslakkas.microservices.unitformulas;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UnitFormula {
	
	@Id
	private long id;
	
	@Column(name = "UNIT_FROM")
	private String from;
	
	@Column(name = "UNIT_TO")
	private String to;
	
	private BigDecimal multiplyBy;
	
	public UnitFormula() {
		
	}
	
	public UnitFormula(long id, String from, String to, BigDecimal multiplyBy) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.multiplyBy = multiplyBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getMultiplyBy() {
		return multiplyBy;
	}

	public void setMultiplyBy(BigDecimal multiplyBy) {
		this.multiplyBy = multiplyBy;
	}
	
	
	
	

}
