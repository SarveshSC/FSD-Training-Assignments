package com.hexaware.fbsresthibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fbsresthibernate.entities.Airport;
import com.hexaware.fbsresthibernate.service.IAirportService;

@RestController
@RequestMapping("api/airports")
public class AirportRestController {
	
	@Autowired
	IAirportService service;
	
	@PostMapping("/add")
	public Airport addAirport(@RequestBody Airport airport) {
		return service.addAirport(airport);
	}
	
	@PutMapping("/update")
	public Airport updateAirport(@RequestBody Airport airport) {
		return service.updateAirport(airport);
	}
	
	@GetMapping("/getbycode/{code}")
	public Airport getAirportbyCode(@PathVariable String code) {
		return service.getAirportbyCode(code);
	}
	
	@GetMapping("/getAll")
	public List<Airport> getAll(){
		return service.selectAllAirport();
	}
}
