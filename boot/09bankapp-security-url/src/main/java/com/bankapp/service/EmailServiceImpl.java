package com.bankapp.service;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendEmail(String emailId, String message) {
	
		System.out.println("email is send to " +emailId +" with "+ message);
	}

}
