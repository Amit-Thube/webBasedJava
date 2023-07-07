package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequestDto;
import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	//dep
	@Autowired
	private EmployeeService empservice;

	public EmployeeController() {
		System.out.println("in ctor of"+getClass());
	}
	
	@GetMapping()
	public List<Employee> showAllEmployee(){
		System.out.println("in getAllEmployee");
		return empservice.getAllEmployees();
	}
	
	@PostMapping
	public ResponseEntity<?> addEmp(@RequestBody Employee transientEmp)
	{
		System.out.println("in add emp of "+getClass());
		
		return new ResponseEntity<>(empservice.addEmployee(transientEmp),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Employee showEmployee(@PathVariable Long id) {
		
		return empservice.getEmployee(id);
	}
	
	@PutMapping
	public Employee updateEmp(@RequestBody Employee transientEmp)
	{
		return empservice.updateEmployee(transientEmp);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmp(@PathVariable Long id)
	{
		return empservice.removeEmp(id);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateEmp(@RequestBody @Valid AuthRequestDto request)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(empservice.authEmp(request));
	}

}
