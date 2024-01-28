package com.hexaware.springboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springboot1.dao.EmployeeDAOImpl;
import com.hexaware.springboot1.dao.IEmployeeDAO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDAO dao = new EmployeeDAOImpl();

	@Override
	public void getService() {
		dao.getService();
	}
}
