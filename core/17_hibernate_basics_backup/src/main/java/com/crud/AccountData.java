package com.crud;

public class AccountData {
	private String name;
	private Double balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public AccountData(String name, Double balance) {
		this.name = name;
		this.balance = balance;
	}
	public AccountData() {}
	@Override
	public String toString() {
		return "AccountData [name=" + name + ", balance=" + balance + "]";
	}
	
	
}
