package com.zavada.app.service;

import java.util.List;
import java.util.Optional;

import com.zavada.app.domain.dto.TeacherDTO;

public interface TeacherService {

	void save(TeacherDTO dto);
	
	Optional<TeacherDTO> findById(Long id);

	Optional<TeacherDTO> findByTeacherId(String teacherId);
	
	List<TeacherDTO> findAll();
	
	void delete(String teacherId);
}
