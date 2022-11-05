package com.customerapp.entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	public Customer(String emailId, String name, LocalDate dateOfBirth) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
