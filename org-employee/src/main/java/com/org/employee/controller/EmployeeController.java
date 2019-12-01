package com.org.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.employee.domain.Address;
import com.org.employee.domain.Employee;
import com.org.employee.feign.AddressControllerProxy;
import com.org.employee.service.EmployeeService;

@RestController("employee")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired(required = false)
	private AddressControllerProxy addressControllerProxy;
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@PostMapping("/addEmployees")
	public void addEmployees(@RequestBody List<Employee> employees) {
		employeeService.addEmployees(employees);
	}

	@GetMapping("/getEmployee/{employeeId}/{addressId}")
	public Optional<Employee> getEmployeeById(@PathVariable("employeeId") String employeeId,
			@PathVariable("addressId") String addressId) {
		System.out.println("employeeId : " + employeeId + " addressId : " + addressId);
		Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
		System.out.println("Employee : " + employee);
		System.out.println("addressControllerProxy : " + addressControllerProxy);
		try {
			Optional<Address> address = addressControllerProxy.getAddressById(addressId);
			System.out.println("address : " + address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return employees;
	}
}
