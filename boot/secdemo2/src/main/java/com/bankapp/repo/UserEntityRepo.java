package com.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.UserEntity;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Integer>{
	public UserEntity findByUsername(String username);
	
}
