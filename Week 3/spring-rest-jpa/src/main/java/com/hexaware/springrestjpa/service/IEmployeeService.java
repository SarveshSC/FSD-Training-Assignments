package com.hexaware.springrestjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.springrestjpa.entities.Employee;

@Service
public interface IEmployeeService {

	public Employee addEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public Employee getEmployeeById(Long empId);

	public String deleteEmployeeById(Long empId);

	public List<Employee> getAllEmployees();

	public List<Employee> findByempName(String name);

	public List<Employee> findBySalaryGT(double salary);

	public List<Employee> getBySalarySorted();

	public List<Employee> getBySalaryRange(double min, double max);

	public int deleteByEname(String empName);
}
