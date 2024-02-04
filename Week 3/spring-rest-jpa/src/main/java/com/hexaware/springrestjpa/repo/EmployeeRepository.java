package com.hexaware.springrestjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.springrestjpa.entities.Employee;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByempName(String name);
	List<Employee> findBySalaryGreaterThan(double salary);
	
	@Query("select e from Employee e where  e.salary Between ?1 and ?2")// JPL QUERY			
	List<Employee> getBySalRange(double min, double max);		


	@Modifying
	@Query("delete from Employee e where e.empName = ?1")
	int deleteByEname(String empName);
}
