package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Employee;
import java.lang.String;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//method for auth
	Optional<Employee> findByEmailAndPassword(String em, String pass);
}
