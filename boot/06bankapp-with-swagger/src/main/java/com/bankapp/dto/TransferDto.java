package com.bankapp.dto;

import lombok.Data;

@Data
public class TransferDto {
	private Integer fromAccId;
	private Integer toAccId;
	private Double amount;
}
