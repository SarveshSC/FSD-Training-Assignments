package com.hexaware.springrestjpa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	Logger logger = LoggerFactory.getLogger(Employee.class);

	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee addEmployee(Employee emp) {
		logger.info(emp + " is added from service");
		return repo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long empId) {
//		return repo.getReferenceById(empId);

//		Optional<Employee> optional = repo.findById(empId);
//		Employee emp = null;
//		if(optional.isPresent()) {
//			emp = optional.get();
//		}
//		return emp;

		return repo.findById(empId).orElse(null);

	}

	@Override
	public String deleteEmployeeById(Long empId) {
		repo.deleteById(empId);
		return "record deleted";
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public List<Employee> findByempName(String name) {
		return repo.findByempName(name);
	}

	@Override
	public List<Employee> getBySalarySorted() {
		return repo.findAll(Sort.by(Order.desc("salary")));
		// return repo.findAll(Sort.by("salary"));
	}

	@Override
	public List<Employee> getBySalaryRange(double min, double max) {
		return repo.getBySalRange(min, max);
	}

	@Override
	public int deleteByEname(String empName) {
		return repo.deleteByEname(empName);
	}

	@Override
	public List<Employee> findBySalaryGT(double salary) {
		return repo.findBySalaryGreaterThan(salary);
	}

	public static boolean validateEmployeeData(Employee emp) {
		boolean flag = false;
		if (emp.getEmpId() > 99 && emp.getSalary() > 5000) {
			flag = true;
		}
		return flag;

	}

}
