package com.crud;

public class Account {
	private int id;
	private String name;
	private Double balance;

	public Account() {}
	public Account(int id, String name, Double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	public Account(String name, Double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	
	
}
