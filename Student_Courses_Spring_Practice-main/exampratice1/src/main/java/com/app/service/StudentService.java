package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.dto.StudentResponseDTO;
import com.app.entities.Student;
import com.app.exception_handler.CustomException;

public interface StudentService {
	
	List<StudentResponseDTO> getAllStudents();
	ApiResponse addStudentDetails(StudentDTO studDto) throws CustomException;
	Student updateStudentDetails(Long  studId,String email) throws CustomException;
	ApiResponse deleteStudRecord(Long studId);
	
}
