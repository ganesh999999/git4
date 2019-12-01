package com.org.employee.service;

import java.util.List;
import java.util.Optional;

import com.org.employee.domain.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee employee);

	void addEmployees(List<Employee> employees);

	Optional<Employee> getEmployeeById(String id);

	List<Employee> getEmployees();
	
}
