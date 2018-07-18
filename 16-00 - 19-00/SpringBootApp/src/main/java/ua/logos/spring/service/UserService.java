package ua.logos.spring.service;

import java.util.List;

import ua.logos.spring.entity.UserEntity;

public interface UserService {

	void save(UserEntity entity);
	
	List<UserEntity> findAll();
	
	UserEntity findById(Long id);
	
	void delete(Long id);
	
}
