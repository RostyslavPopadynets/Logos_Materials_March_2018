package com.zavada.app.domain.dto;

import java.util.List;

import com.zavada.app.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {

	private Long id;
	private String teacherId;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private String description;
	private List<Course> courses;
}
