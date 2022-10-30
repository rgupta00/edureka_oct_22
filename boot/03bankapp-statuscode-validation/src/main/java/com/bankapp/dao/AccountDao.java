package com.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.entities.Account;
//spring data make life very easy
public interface AccountDao extends JpaRepository<Account, Integer>{

}
