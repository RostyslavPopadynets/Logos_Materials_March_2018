package com.zavada.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zavada.app.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	Optional<Teacher> findByEmail(String email);

	Optional<Teacher> findByTeacherId(String userId);

	Boolean existsByEmail(String email);

	Boolean existsByTeacherId(String userId);

	Boolean existsByEmailOrTeacherId(String email, String userId);

}
