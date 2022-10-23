package com.crud;

public class AccountData {
	private int id;
	private String name;
	
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
	
	
	public AccountData(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public AccountData() {}
	
	@Override
	public String toString() {
		return "AccountData [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
