package com.org.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.employee.domain.Employee;
import com.org.employee.repository.EmployeeRepository;
import com.org.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void addEmployees(List<Employee> employees) {
		employeeRepository.saveAll(employees);
	}

	@Override
	public Optional<Employee> getEmployeeById(String id) {
		Optional<Employee> employee = (Optional<Employee>) employeeRepository.findById(id);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

}
