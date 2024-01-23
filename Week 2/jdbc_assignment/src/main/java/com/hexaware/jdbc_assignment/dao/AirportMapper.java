package com.hexaware.jdbc_assignment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hexaware.jdbc_assignment.entity.Airport;

public class AirportMapper implements RowMapper<Airport>{

	@Override
	public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
		Airport airport = new Airport();
		airport.setIATACode(rs.getString("iatacode"));
		airport.setAirportName(rs.getString("airportName"));
		airport.setLocation(rs.getString("location"));
		return airport;
	}

}
