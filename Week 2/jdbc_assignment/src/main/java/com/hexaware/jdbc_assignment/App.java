package com.hexaware.jdbc_assignment;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.jdbc_assignment.config.AppConfig;
import com.hexaware.jdbc_assignment.entity.Airport;
import com.hexaware.jdbc_assignment.exception.AirportNotFoundException;
import com.hexaware.jdbc_assignment.service.AirportServiceImpl;
import com.hexaware.jdbc_assignment.service.IAirportService;

public class App {
	
	static Scanner scanner = new Scanner(System.in);
	public static void main( String[] args ) throws AirportNotFoundException{
		
		Airport airport = null;
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IAirportService service = context.getBean(AirportServiceImpl.class);

		boolean flag = true;

		while (flag) {
			System.out.println("***WELCOME***"); 
			System.out.println("Airport Management System");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Select by Airport Code");
			System.out.println("5. Show all airports");
			System.out.println("6. EXIT");

			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				airport = readData();
				boolean isAdded = service.addAirport(airport);
				if(isAdded) {
					System.out.println("Airport Added successfully");
				}
				else {
					System.err.println("Operation Failed");
				}
				break;
				
			case 2:
				airport = readData();
				boolean isUpdated = service.updateAirport(airport);
				if(isUpdated) {
					System.out.println("Airport Updated successfully");
				}
				else {
					throw new AirportNotFoundException();
				}
				break;
				
			case 3:
				System.out.println("Enter airport code");
				boolean isDeleted = service.deleteAirport(scanner.next());
				if(isDeleted){
					System.out.println("Airport Deleted successfully");
				}
				else {
					throw new AirportNotFoundException();
				}
				
			case 4:
				System.out.println("Enter airport code");
				String code = scanner.nextLine();
				airport = service.selectAirportByCode(code);
				if(airport != null){
					System.out.println(airport);
				}
				else {
					throw new AirportNotFoundException();
				}
				
			case 5:
				System.out.println("Here is the list of all airports");
				List<Airport> list = service.selectAllAirport();
				for(Airport air : list) {
					System.out.println(air);
				}
				break;
				
			case 6:
				System.out.println("Thank you");
				flag = false;
			default:
				break;
			}
		}
    }
	public static Airport readData() {
		System.out.println("Enter Airport Code");
		String iatacode = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Airport Name");
		String airportName = scanner.nextLine();
		System.out.println("Enter Airport Location");
		String location = scanner.nextLine();
		return new Airport(iatacode, airportName, location);
	}
}
