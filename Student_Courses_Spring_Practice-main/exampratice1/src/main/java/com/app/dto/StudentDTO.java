package com.app.dto;

import com.app.entities.CourseDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private String studentName;
	private String email;
	private CourseDetail courseDetail;
	private int score;
	private Long courseId;
}
