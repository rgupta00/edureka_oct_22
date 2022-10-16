package com.demo;
import java.util.*;
public class Bank {
	private String bankName;
	private List<Account> accounts;
	
	private Map<String, BranchLocation> branches;
	
	private Map<String, Integer> customerCount;
	
	public void setCustomerCount(Map<String, Integer> customerCount) {
		this.customerCount = customerCount;
	}

	public void setBranches(Map<String, BranchLocation> branches) {
		this.branches = branches;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void printDetails() {
		System.out.println("bank name: "+ bankName);
		System.out.println("accounts in bank");
		accounts.forEach(a-> System.out.println(a));
		
		branches.forEach((bName,bLoc)-> System.out.println(bName+":"+bLoc));
		customerCount.forEach((bName, customerCount)-> System.out.println(bName+": "+ customerCount));
	}
	
}
