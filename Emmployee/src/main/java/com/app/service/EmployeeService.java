package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee transientEmp);
	
	Employee getEmployee(Long id);
	
	Employee updateEmployee(Employee transientEmp);
	
	String removeEmp(Long id);
	
	AuthResponseDto authEmp(AuthRequestDto request);

}
