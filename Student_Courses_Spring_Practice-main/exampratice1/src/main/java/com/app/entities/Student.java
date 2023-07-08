package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Student extends BaseEntity {
	
	
	@Column(name="sname",length = 20)
	private String studentName;
	@Column(length = 20)
	private String email;
	@Enumerated(EnumType.STRING)
	private CourseDetail courseDetail;
	private int score;
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course course;
	
	public Student(String studentName, String email, CourseDetail courseDetail, int score) {
		super();
		this.studentName = studentName;
		this.email = email;
		this.courseDetail = courseDetail;
		this.score = score;
	}
	
}
