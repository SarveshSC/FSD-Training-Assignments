package com.hexaware.hibernate_crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.hibernate_crud.HibernateUtil;
import com.hexaware.hibernate_crud.entity.Airport;

public class AirportDAOImpl implements IAirportDAO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	Serializable serial = null;

	@Override
	public Serializable addAirport(Airport airport) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		serial = session.save(airport);
		txn.commit();
		session.close();
		return serial;

	}

	@Override
	public boolean updateAirport(Airport airport) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.update(airport);
			txn.commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			txn.rollback();
			session.close();
			return false;
		}
		
	}

	@Override
	public Serializable deleteAirport(String airportCode) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Airport airport = (Airport) session.get(Airport.class, airportCode);
		if (airport != null) {
			session.delete(airport);
			txn.commit();
		} else {
			System.err.println("Airport not found");
		}
		session.close();
		return serial;
	}

	@Override
	public List<Airport> selectAirportByLocation(String location) {
		Session session = sessionFactory.openSession();
		
		String selectQuery = "select a from Airport a where a.location = ?1";
		Query query = session.createQuery(selectQuery,Airport.class).setParameter(1, location);
//		query.setParameter(1, location);
		System.out.println(location);
		List<Airport> list = query.getResultList();
		session.close();
		return list;
	}

	@Override
	public List<Airport> selectAllAirport() {
		Session session = sessionFactory.openSession();
		session.clear();
		Query query = session.createNamedQuery("getAllAirports");
		List<Airport> list = query.getResultList();
		session.close();
		return list;
	}

}
