package com.zavada.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zavada.app.dto.TeacherDTO;
import com.zavada.app.service.TeacherService;

@RestController
@RequestMapping("teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	// @ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Void> saveTeacher(@RequestBody TeacherDTO teacherDTO) {
		teacherService.save(teacherDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
		return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{teacherId}")
	public ResponseEntity<TeacherDTO> getTeacherByTeacherId(@PathVariable("teacherId") String teacherId) {
		return new ResponseEntity<>(teacherService.findByTeacherId(teacherId).get(), HttpStatus.OK);
	}

}
