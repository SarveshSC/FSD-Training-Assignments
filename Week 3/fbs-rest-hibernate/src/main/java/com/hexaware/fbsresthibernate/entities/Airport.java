package com.hexaware.fbsresthibernate.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airport {
	
	@Id
	private String IATACode;

	private String airportName;
	private String location;
	
	public Airport() {
		super();
	}
	public Airport(String IATACode, String airportName, String location) {
		super();
		this.IATACode = IATACode;
		this.airportName = airportName;
		this.location = location;
	}
	public String getIATACode() {
		return IATACode;
	}
	public void setIATACode(String iATACode) {
		IATACode = iATACode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Airports [IATACode=" + IATACode + ", airportName=" + airportName + ", location=" + location + "]";
	}
}
