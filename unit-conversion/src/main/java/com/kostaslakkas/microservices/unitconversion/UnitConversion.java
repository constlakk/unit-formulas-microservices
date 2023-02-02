package com.kostaslakkas.microservices.unitconversion;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UnitConversion {
	
	@Id
	private long id;
	
	@Column(name = "UNIT_FROM")
	private String from;
	
	@Column(name = "UNIT_TO")
	private String to;
	
	private BigDecimal quantity;
	
	private BigDecimal multiplyBy;
	
	private BigDecimal result;
	
	public UnitConversion() {
		
	}

	public UnitConversion(long id, String from, String to, BigDecimal quantity, BigDecimal multiplyBy,
			BigDecimal result) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.multiplyBy = multiplyBy;
		this.result = result;
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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}
	
	

}
