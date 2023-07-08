package com.app.dto;

import com.app.entities.CourseDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
	private String studentName;
	private String email;
	private CourseDetail courseDetail;
	private int score;
	
}
