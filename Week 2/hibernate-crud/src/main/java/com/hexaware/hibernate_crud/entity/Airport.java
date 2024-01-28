package com.hexaware.hibernate_crud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="airports")
@NamedQueries(
		{
			@NamedQuery(name="getAllAirports", query="select a from Airport a")
		}
)
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
