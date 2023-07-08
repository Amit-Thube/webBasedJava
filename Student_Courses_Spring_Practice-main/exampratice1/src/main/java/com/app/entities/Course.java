package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends BaseEntity{
	/*
	 * course title(unique) , start date , end date , fees , min score
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="Title")
	private CourseDetail courseTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private int fees;
	private int minScore;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course",orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Student> studentList;

	public Course(CourseDetail courseTitle, LocalDate startDate, LocalDate endDate, int fees, int minScore) {
		super();
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minScore = minScore;
	}
	
	
}
