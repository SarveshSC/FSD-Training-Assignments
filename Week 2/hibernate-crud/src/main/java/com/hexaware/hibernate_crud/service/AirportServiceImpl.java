package com.hexaware.hibernate_crud.service;

import java.io.Serializable;
import java.util.List;

import com.hexaware.hibernate_crud.dao.AirportDAOImpl;
import com.hexaware.hibernate_crud.dao.IAirportDAO;
import com.hexaware.hibernate_crud.entity.Airport;

public class AirportServiceImpl implements IAirportService{
	
	IAirportDAO dao = new AirportDAOImpl();
	@Override
	public Serializable addAirport(Airport airport) {
		return dao.addAirport(airport);
	}

	@Override
	public boolean updateAirport(Airport airport) {
		return dao.updateAirport(airport);
	}

	@Override
	public Serializable deleteAirport(String airportCode) {
		return dao.deleteAirport(airportCode);
	}

	@Override
	public List<Airport> selectAirportByLocation(String location) {
		return dao.selectAirportByLocation(location);
	}

	@Override
	public List<Airport> selectAllAirport() {
		return dao.selectAllAirport();
	}

}
