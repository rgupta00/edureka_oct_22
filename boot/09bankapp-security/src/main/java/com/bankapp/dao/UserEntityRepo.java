package com.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.UserEntity;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Integer>{
	public UserEntity findByUsername(String username);
	
}
