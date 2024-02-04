package com.hexaware.springrestjpa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.springrestjpa.entities.Employee;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class EmployeeServiceImplTest {
	
	Logger logger = LoggerFactory.getLogger(Employee.class);
	
	@Autowired
	IEmployeeService service;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddEmployee() {
		Employee emp = new Employee(106, "Ferdinand", 42000.0);
		Employee emp_test = service.addEmployee(emp);
		assertNotNull(emp_test);
		logger.info("Employee added successfully");
	}

	@Test
	void testUpdateEmployee() {
		Employee emp = new Employee(106, "Ferdinand", 52000.0);
		Employee emp_test = service.updateEmployee(emp);
		assertEquals(emp, emp_test);
		logger.info("Employee updated successfully");
	}

	@Test
	void testGetEmployeeById() {
		Employee emp = service.getEmployeeById((long) 101);
		assertEquals(101, emp.getEmpId());
	}

	@Test
	void testGetAllEmployees() {
		List<Employee> list = service.getAllEmployees();
		boolean flag = list.isEmpty();
		assertFalse(flag);
	}

}
