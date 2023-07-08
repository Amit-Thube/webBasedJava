package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.dto.StudentResponseDTO;
import com.app.entities.Student;
import com.app.exception_handler.CustomException;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StuentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<StudentResponseDTO> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> studentList=studRepo.findAll();
		List<StudentResponseDTO> s1=new ArrayList<>();
		studentList.forEach((student)->{
			s1.add(mapper.map(student, StudentResponseDTO.class));
		});
		return s1;
	}

	@Override
	public ApiResponse addStudentDetails(StudentDTO studDto) throws CustomException {
		Student stud=new Student(studDto.getStudentName(),studDto.getEmail(),studDto.getCourseDetail(),studDto.getScore());
		courseRepo.findById(studDto.getCourseId()).map((course)->{
			stud.setCourse(course);
			return studRepo.save(stud);
		}).orElseThrow(()->
			new CustomException("Student details are not added"));
		return new ApiResponse("Student added succesfully");
	}

	@Override
	public Student updateStudentDetails(Long studId,String email) throws CustomException {
		// TODO Auto-generated method stub
		Student stud=studRepo.findById(studId).orElseThrow(()->
			 new CustomException("Student not found")
			 
		);
		stud.setEmail(email);
		return studRepo.save(stud);
	}

	@Override
	public ApiResponse deleteStudRecord(Long studId) {
		// TODO Auto-generated method stub
		if(studRepo.existsById(studId)) {
			studRepo.deleteById(studId);
		}else {
			return new ApiResponse("student does not exists");
		}
		return new ApiResponse("student record deleted successfully");
	}
	
	

}
