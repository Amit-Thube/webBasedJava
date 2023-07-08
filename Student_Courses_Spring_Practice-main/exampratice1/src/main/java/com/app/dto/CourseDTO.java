package com.app.dto;

import java.time.LocalDate;

import com.app.entities.CourseDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
	private CourseDetail courseTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private int fees;
	private int minScore;
}
