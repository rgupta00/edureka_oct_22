package com.bankapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	 private String errorMessage;
	 private String errorCode;
	 private LocalDateTime timeStamp;
	 private String toContact;
}
