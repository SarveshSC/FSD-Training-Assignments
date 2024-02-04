package com.hexaware.springrestjpa.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.springrestjpa.entities.Employee;

@SpringBootTest
class EmployeeRestControllerTest {

	@Autowired
	RestTemplate restTemplate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddEmployee() {
		Employee emp = new Employee(108, "Steve", 40000.0);

		ResponseEntity<Employee> response = restTemplate.postForEntity("http://localhost:8080/api/employees/add", emp,
				Employee.class);

		Employee e = response.getBody();
		assertEquals(e.getEmpId(), 108);
	}

	@Test
	void testUpdateEmployee() {
//		Employee emp = new Employee(105, "Simon", 40000.0);
//
//		ResponseEntity<Employee> response = restTemplate.postForEntity("http://localhost:8080/api/employees/add", emp,
//				Employee.class);
//
//		Employee e = response.getBody();
//		assertEquals(emp, e);
	}

	@Test
	void testGetEmployeeById() {
		int eid = 107;
		ResponseEntity<Employee> response = restTemplate
				.getForEntity("http://localhost:8080/api/employees/getById/" + eid, Employee.class);

		Employee emp = response.getBody();

		assertNotNull(emp);
		assertEquals(107, emp.getEmpId());
	}

	@Test
	void testGetAll() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/api/employees/getall",
				List.class);

		List<Employee> list = response.getBody();

		assertTrue(list.size() > 0);

		List<Employee> list2 = restTemplate.getForObject("http://localhost:8080/api/employees/getall", List.class);

		assertNotNull(list2);
	}

}
