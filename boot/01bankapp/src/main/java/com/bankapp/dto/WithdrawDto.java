package com.bankapp.dto;

import lombok.Data;

@Data
public class WithdrawDto {
	private Integer accId;
	private Double amount;
}
