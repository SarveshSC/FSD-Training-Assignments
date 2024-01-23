package com.hexaware.jdbc_assignment.exception;

public class AirportNotFoundException extends Exception {
	public AirportNotFoundException() {
		System.err.println("Airport not found");
	}
}
