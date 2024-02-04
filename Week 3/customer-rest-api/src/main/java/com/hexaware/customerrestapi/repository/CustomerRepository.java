package com.hexaware.customerrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.customerrestapi.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
