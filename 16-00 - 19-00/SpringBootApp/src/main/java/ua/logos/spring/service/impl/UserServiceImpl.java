package ua.logos.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.spring.entity.UserEntity;
import ua.logos.spring.repository.UserRepository;
import ua.logos.spring.service.UserService;

// @Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(UserEntity entity) {
		userRepository.save(entity);
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
