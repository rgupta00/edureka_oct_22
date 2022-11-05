package com.bankapp.service;

import com.bankapp.entity.UserEntity;

public interface UserService {
	public UserEntity findByUsername(String username);
	public void addUserEntity(UserEntity entity);
}
