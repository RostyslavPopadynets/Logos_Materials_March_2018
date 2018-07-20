package ua.logos.service;

import java.util.List;

import ua.logos.entity.UserEntity;

public interface UserService {

	void create(UserEntity entity);
	
	List<UserEntity> findAll();
	
	UserEntity findByUserId(String userId);
		
}
