package com.bankapp.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dao.ErrorInfo;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(BankAccountNotFoundException ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(ex.getMessage());
		errorInfo.setTimeStamp(LocalDateTime.now());
		
		errorInfo.setToContact("admin@champbank.com");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}

}
