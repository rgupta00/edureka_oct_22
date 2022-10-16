package com.demo;

public class BranchLocation {

	private String address;
	private String city;
	
	
	
	
	public BranchLocation() {}


	public BranchLocation(String address, String city) {
		this.address = address;
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "BranchLocation [address=" + address + ", city=" + city + "]";
	}
	
	
}
