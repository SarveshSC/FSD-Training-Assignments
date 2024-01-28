package com.hexaware.jdbc_assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.jdbc_assignment.entity.Airport;

@Service
public interface IAirportService {
	public boolean addAirport(Airport airport);
	public boolean updateAirport(Airport airport);
	public boolean deleteAirport(String airportCode);
	public List<Airport> selectAirportByLocation(String location);
	public List<Airport> selectAllAirport();
}
