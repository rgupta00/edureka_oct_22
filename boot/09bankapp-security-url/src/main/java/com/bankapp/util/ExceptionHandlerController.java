package com.bankapp.util;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorInfo;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handle500(Exception ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorInfo.setErrorMessage("pls try after some time");
		errorInfo.setTimeStamp(LocalDateTime.now());
		
		errorInfo.setToContact("admin@champbank.com");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}
	
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(BankAccountNotFoundException ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(ex.getMessage());
		errorInfo.setTimeStamp(LocalDateTime.now());
		
		errorInfo.setToContact("admin@champbank.com");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<ErrorInfo> handleAccessDeniedException(AccessDeniedException ex) {
		ErrorInfo details = new ErrorInfo();
		details.setTimeStamp(LocalDateTime.now());
		details.setToContact("rgupta.mtech@gmail.com");
		details.setErrorCode(HttpStatus.FORBIDDEN.toString());
        return new ResponseEntity<>(details, HttpStatus.FORBIDDEN);
   }
	
	
	
	
	
	//MethodArgumentNotValidException
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		
		//i want to extract out the proper error message from ex object MethodArgumentNotValidException
		
		String errorMessages=ex.getBindingResult().getAllErrors()
				.stream().map(x-> x.getDefaultMessage())
				.collect(Collectors.joining(","));
		
		
		errorInfo.setErrorMessage(errorMessages);
		
		
		errorInfo.setTimeStamp(LocalDateTime.now());
		
		errorInfo.setToContact("admin@champbank.com");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}

}
