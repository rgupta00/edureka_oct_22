package com.bankapp.dto;

public class TransferDto {
	private int fromAccId;
	private int toAccId;
	private double amount;
	
	public int getFromAccId() {
		return fromAccId;
	}
	public void setFromAccId(int fromAccId) {
		this.fromAccId = fromAccId;
	}
	public int getToAccId() {
		return toAccId;
	}
	public void setToAccId(int toAccId) {
		this.toAccId = toAccId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransferDto(int fromAccId, int toAccId, double amount) {
		super();
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.amount = amount;
	}
	public TransferDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
