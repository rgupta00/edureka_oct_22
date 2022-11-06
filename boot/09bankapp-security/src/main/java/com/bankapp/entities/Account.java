package com.bankapp.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acc_table")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "{account.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{account.name.invalid}")
	private String name;
	
	@NotNull(message = "{account.balance.absent}")
	@Range(min = 100, max = 1000000, message = "{account.balance.invalid}")
	private BigDecimal balance;
	
	@NotNull(message = "email should not be null")
	@Email(message = "email should be valid")
	private String email;
	
	@NotNull(message = "account.phone.absent")
	
	private String phone;
	public Account(String name, BigDecimal balance, String email, String phone) {
		super();
		this.name = name;
		this.balance = balance;
		this.email = email;
		this.phone = phone;
	}
	
	
	
}
