package com.hexaware.jdbc_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.jdbc_assignment.dao.IAirportDAO;
import com.hexaware.jdbc_assignment.entity.Airport;

@Service
public class AirportServiceImpl implements IAirportService {

	@Autowired
	IAirportDAO dao;
	
	@Override
	public boolean addAirport(Airport airport) {
		return dao.addAirport(airport);
	}

	@Override
	public boolean updateAirport(Airport airport) {
		return dao.updateAirport(airport);
	}

	@Override
	public boolean deleteAirport(String airportCode) {
		return dao.deleteAirport(airportCode);
	}

	@Override
	public Airport selectAirportByCode(String airportCode) {
		return dao.selectAirportByCode(airportCode);
	}

	@Override
	public List<Airport> selectAllAirport() {
		return dao.selectAllAirport();
	}

}
