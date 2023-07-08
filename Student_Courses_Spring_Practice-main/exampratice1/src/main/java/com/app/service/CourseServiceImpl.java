package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.dto.CourseResponseDTO;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CourseResponseDTO> getAllCourses() {
		
		List<Course>courseList=courseRepo.findAll();
		List<CourseResponseDTO> c1=new ArrayList<>();
//		courseList.forEach((course)->{
//			c1.add(mapper.map(course, CourseResponseDTO.class));
//		});
		for(Course c:courseList) {
			c1.add(mapper.map(c, CourseResponseDTO.class));
		}
		return c1;
	}

	@Override
	public ApiResponse addCourse(CourseDTO courseDTO) {
		// TODO Auto-generated method stub
		System.out.println(courseDTO);
		Course newCourse=new Course(courseDTO.getCourseTitle(),courseDTO.getStartDate(),courseDTO.getEndDate(),courseDTO.getFees(),courseDTO.getMinScore());
		courseRepo.save(newCourse);
		return new ApiResponse("Course added successfully");
	}
	
}
