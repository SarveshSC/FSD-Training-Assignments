package com.hexaware.springrestjpa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.exception.EmployeeNotFoundException;
import com.hexaware.springrestjpa.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	
	Logger logger = LoggerFactory.getLogger(Employee.class);

	@Autowired
	IEmployeeService service;

	@PostMapping("/add")
	public Employee insertEmployee(@RequestBody Employee emp) {
		logger.warn("Employee object is not null in Rest Controller");
		return service.addEmployee(emp);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}

	@GetMapping("/getById/{eid}")
	public Employee getEmployeeById(@PathVariable long eid) throws EmployeeNotFoundException{
		Employee emp = service.getEmployeeById(eid);
		if(emp == null) {
			throw new EmployeeNotFoundException();
		}
		return emp;
	}

	@GetMapping("/getall")
	public List<Employee> getAll() {
		return service.getAllEmployees();
	}

	@DeleteMapping("/delete/{eid}")
	public String deleteById(@PathVariable long eid) {
		return service.deleteEmployeeById(eid);
	}

	@GetMapping("getByName/{ename}")
	public List<Employee> getByName(@PathVariable String ename) {
		return service.findByempName(ename);
	}

	@GetMapping("/getbysalarygt/{salary}")
	public List<Employee> getBySalaryGT(@PathVariable double salary) {
		return service.findBySalaryGT(salary);
	}

	@GetMapping("/getbysalarysorted")
	public List<Employee> getBySalarySorted() {
		return service.getBySalarySorted();
	}

	@GetMapping("/getsalarybyrange/{min}/{max}")
	public List<Employee> getBySalarySorted(@PathVariable double min, @PathVariable double max) {
		return service.getBySalaryRange(min, max);
	}

	@DeleteMapping("/deletebyname/{empName}")
	public String deleteByEname(@PathVariable String empName) {
		int count = service.deleteByEname(empName);
		return count + " record deleted";
	}
}
