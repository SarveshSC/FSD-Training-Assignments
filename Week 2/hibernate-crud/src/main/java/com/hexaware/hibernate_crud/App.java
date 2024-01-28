package com.hexaware.hibernate_crud;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.hibernate_crud.entity.Airport;
import com.hexaware.hibernate_crud.service.AirportServiceImpl;
import com.hexaware.hibernate_crud.service.IAirportService;

public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Airport airport = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		IAirportService service = new AirportServiceImpl();
		
		Transaction txn = session.beginTransaction();

		boolean flag = true;
		Airport a1 = session.get(Airport.class, "BOM");
		System.out.println(a1);

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
			System.out.println(choice);
			switch (choice) {
			case 1:
				airport = readData();
				Serializable add = service.addAirport(airport);
				if(add != null) {
					System.out.println("Airport added successfully");
				}
				else {
					System.out.println("Operation Failed");
				}
				break;

			case 2:
				airport = readData();
				boolean update = service.updateAirport(airport);
				if(update) {
					System.out.println("Airport updated successfully");
				}
				else {
					System.out.println("Operation Failed");
				}
				break;

			case 3:
				System.out.println("Enter airport code ");
				scanner.nextLine();
				String code = scanner.nextLine();
				Serializable delete = service.deleteAirport(code);
				if(delete == null) {
					System.out.println("Airport deleted successfully");
				}
				else {
					System.out.println("Operation Failed");
				}
				break;

			case 4:
				System.out.println("Enter location ");
				scanner.nextLine();
				String loc = scanner.nextLine();
				List<Airport> list = service.selectAirportByLocation(loc);
				for(Airport a : list) {
					System.out.println(a);
				}
				break;

			case 5:
				System.out.println("List of all Airports ");
				List<Airport> allAirports = service.selectAllAirport();
				for(Airport a : allAirports) {
					System.out.println(a);
				}
				break;

			case 6:
				flag = false;
				System.out.println("Thank you");
				session.close();
				break;

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
