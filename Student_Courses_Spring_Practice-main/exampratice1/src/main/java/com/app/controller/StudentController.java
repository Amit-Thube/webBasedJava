package com.app.controller;

import java.util.List;

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

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.dto.StudentResponseDTO;
import com.app.entities.Student;
import com.app.exception_handler.CustomException;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	@GetMapping
	public List<StudentResponseDTO> getAllStudentDetails(){
		return studService.getAllStudents();
	}
	
	@PostMapping("/addstudent")
	public ApiResponse addStudent(@RequestBody StudentDTO stud) throws CustomException {
		return studService.addStudentDetails(stud);
	}
	
	@PutMapping("/{studId}/students/{email}")
	public ResponseEntity<?>updateStudDetails(@RequestBody @PathVariable Long  studId,@PathVariable String email) throws CustomException{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studService.updateStudentDetails(studId,email));
	}
	
	@DeleteMapping("/{studId}")
	public ApiResponse deleteStudentDetail(@PathVariable Long studId) {
		return studService.deleteStudRecord(studId);
	}
	
}
