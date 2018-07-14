package com.zavada.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zavada.app.entity.Course;

import lombok.Data;

@Data
public class TeacherDTO {
	
	@JsonIgnore
	private Long id;
	
	private String teacherId;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private String description;
	private List<Course> courses;
}
