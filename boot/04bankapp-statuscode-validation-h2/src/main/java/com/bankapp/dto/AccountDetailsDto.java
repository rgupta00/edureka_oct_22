package com.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetailsDto {
	private int id;
	private String email;
	private String phone;
}
