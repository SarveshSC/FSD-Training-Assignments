package com.hexaware.jdbc_assignment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hexaware.jdbc_assignment.entity.Airport;

@Repository
public interface IAirportDAO {
	public boolean addAirport(Airport airport);
	public boolean updateAirport(Airport airport);
	public boolean deleteAirport(String airportCode);
	public List<Airport> selectAirportByLocation(String location);
	public List<Airport> selectAllAirport();
}
