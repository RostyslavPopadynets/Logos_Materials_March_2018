package com.zavada.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zavada.app.dto.TeacherDTO;
import com.zavada.app.entity.Teacher;
import com.zavada.app.repository.TeacherRepository;
import com.zavada.app.service.TeacherService;
import com.zavada.app.service.utils.StringUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StringUtils stringUtils;

	@Override
	public void save(TeacherDTO dto) {
		Teacher teacher = modelMapper.map(dto, Teacher.class);

		String teacherId = stringUtils.generate();
		if (teacherRepository.existsByEmailOrTeacherId(dto.getEmail(), teacherId)) {
			log.debug("This info exists");
			throw new RuntimeException("Some error happened");
		}

		teacher.setTeacherId(teacherId); // add check exists by email and teacherid
		teacherRepository.save(teacher);
	}

	@Override
	public Optional<TeacherDTO> findById(Long id) {
		return null;
	}

	@Override
	public Optional<TeacherDTO> findByTeacherId(String teacherId) {
		return teacherRepository.findByTeacherId(teacherId).map(entity -> modelMapper.map(entity, TeacherDTO.class));
	}

	@Override
	public List<TeacherDTO> findAll() {
		return teacherRepository.findAll().stream().map(entity -> modelMapper.map(entity, TeacherDTO.class))
				.collect(Collectors.toList());
	}

}
