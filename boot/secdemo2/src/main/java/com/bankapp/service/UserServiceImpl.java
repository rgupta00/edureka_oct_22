package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankapp.entity.UserEntity;
import com.bankapp.repo.UserEntityRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserEntityRepo entityRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserEntity findByUsername(String username) {
		return entityRepo.findByUsername(username);
	}

	@Override
	public void addUserEntity(UserEntity userEntity) {
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));// dont forget to encrpt password before saving to db
		entityRepo.save(userEntity);
	}

}
