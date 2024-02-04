package com.hexaware.fbsresthibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fbsresthibernate.entities.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{
	
}
