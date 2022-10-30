package com.bankapp.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private int id;
	private String name;
	private BigDecimal balance;
	
	private String email;
	private String phone;
	
}
