package com.hexaware.jdbc_assignment.entity;

public class Airport {
	private String IATACode;
	private String airportName;
	private String location;
	
	public Airport() {
		super();
	}
	public Airport(String iATACode, String airportName, String location) {
		super();
		IATACode = iATACode;
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
