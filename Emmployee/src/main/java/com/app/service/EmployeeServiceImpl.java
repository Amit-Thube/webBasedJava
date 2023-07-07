package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Employee> getAllEmployees() {
	System.out.println("in ctor of"+getClass());
		return emprepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee transientEmp) {
		// TODO Auto-generated method stub
		return emprepo.save(transientEmp);
	}

	@Override
	public Employee getEmployee(Long id) {
		
		return emprepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("invalid id"));
	}

	@Override
	public Employee updateEmployee(Employee transientEmp) {
		
		return emprepo.save(transientEmp);
	}

	@Override
	public String removeEmp(Long id) {
		String mesg="Id invalid cannot delete record";
		if(emprepo.existsById(id))
		{
			emprepo.deleteById(id);
			mesg="Deleted Successfully";
		}
		
		return mesg;
	}

	@Override
	public AuthResponseDto authEmp(AuthRequestDto request) {
		
		Employee emp=emprepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(()->new ResourceNotFoundException("Invalid Email or password"));
		AuthResponseDto authresp= mapper.map(emp,AuthResponseDto.class);
		
		return authresp;
	}
	
	

}
