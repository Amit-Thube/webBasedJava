package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService cService;
	
	@GetMapping
	public ResponseEntity<?> getAllCourse(){
		return ResponseEntity.status(HttpStatus.OK).body(cService.getAllCourses());
	}
	
	@PostMapping("/addcourse")
	public ApiResponse addNewCourse(@RequestBody CourseDTO coursedto) {
		return cService.addCourse(coursedto);
	}
	
	
}
