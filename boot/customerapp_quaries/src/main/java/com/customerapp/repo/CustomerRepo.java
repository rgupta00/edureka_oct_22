package com.customerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerapp.entity.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
