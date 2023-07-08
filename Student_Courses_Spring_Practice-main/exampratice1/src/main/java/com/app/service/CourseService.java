package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.dto.CourseResponseDTO;

public interface CourseService {	
	List<CourseResponseDTO> getAllCourses();
	ApiResponse addCourse(CourseDTO courseDTO);
}
