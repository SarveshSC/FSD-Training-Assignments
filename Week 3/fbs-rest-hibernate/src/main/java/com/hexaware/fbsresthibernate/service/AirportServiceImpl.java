package com.hexaware.fbsresthibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fbsresthibernate.entities.Airport;
import com.hexaware.fbsresthibernate.repo.AirportRepository;

@Service
public class AirportServiceImpl implements IAirportService {

	@Autowired
	AirportRepository repo;
	
	@Override
	public Airport addAirport(Airport airport) {
		return repo.save(airport);
	}

	@Override
	public Airport updateAirport(Airport airport) {
		return repo.save(airport);
	}

	@Override
	public String deleteAirport(String airportCode) {
		repo.deleteById(airportCode);
		return "record deleted";
	}
	@Override
	public Airport getAirportbyCode(String code) {
		return repo.findById(code).orElse(null);
	}

	@Override
	public List<Airport> selectAllAirport() {
		return repo.findAll();
	}



}
