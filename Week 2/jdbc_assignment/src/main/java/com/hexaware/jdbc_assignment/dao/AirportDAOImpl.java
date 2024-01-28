package com.hexaware.jdbc_assignment.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hexaware.jdbc_assignment.entity.Airport;

@Repository
public class AirportDAOImpl implements IAirportDAO {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public AirportDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public boolean addAirport(Airport airport) {
		String insertQuery = "insert into airports (iatacode, airportName, location) values (?,?,?)";
		int count = jdbcTemplate.update(insertQuery, airport.getIATACode(), airport.getAirportName(),
				airport.getLocation());
		return count > 0;
	}

	@Override
	public boolean updateAirport(Airport airport) {
		String updateQuery = "update airports set airportName = ?, location = ? where iatacode = ?";
		int count = jdbcTemplate.update(updateQuery, airport.getAirportName(), airport.getLocation(),
				airport.getIATACode());
		return count > 0;
	}

	@Override
	public boolean deleteAirport(String airportCode) {
		String deleteQuery = "delete from airports where iatacode = ?";
		int count = jdbcTemplate.update(deleteQuery, airportCode);
		return count > 0;
	}

	@Override
	public List<Airport> selectAirportByLocation(String location) {
		String selectOne = "select iatacode, airportName, location from airports where location = ?";
		List<Airport> list = (List<Airport>) jdbcTemplate.query(selectOne, new AirportMapper(), location);
		return list;
	}

	@Override
	public List<Airport> selectAllAirport() {
		String selectAll = "select iatacode, airportName, location from airports";
		List<Airport> list = jdbcTemplate.query(selectAll, new AirportMapper());
		return list;
	}

}
