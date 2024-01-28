package com.hexaware.hibernate_crud.dao;

import java.io.Serializable;
import java.util.List;

import com.hexaware.hibernate_crud.entity.Airport;

public interface IAirportDAO {
	public Serializable addAirport(Airport airport);
	public boolean updateAirport(Airport airport);
	public Serializable deleteAirport(String airportCode);
	public List<Airport> selectAirportByLocation(String location);
	public List<Airport> selectAllAirport();
	
}
