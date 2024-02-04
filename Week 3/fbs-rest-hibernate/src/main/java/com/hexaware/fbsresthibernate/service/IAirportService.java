package com.hexaware.fbsresthibernate.service;

import java.util.List;

import com.hexaware.fbsresthibernate.entities.Airport;

public interface IAirportService {
	public Airport addAirport(Airport airport);
	public Airport updateAirport(Airport airport);
	public String deleteAirport(String airportCode);
	public Airport getAirportbyCode(String code);
	public List<Airport> selectAllAirport();
}
