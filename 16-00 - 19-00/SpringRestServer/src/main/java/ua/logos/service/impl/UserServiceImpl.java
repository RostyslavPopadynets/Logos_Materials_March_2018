package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.UserEntity;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;
import ua.logos.service.utils.StringUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StringUtils stringUtils;

	@Override
	public void create(UserEntity entity) {
		String userId = stringUtils.generate();
		entity.setUserId(userId);
		userRepository.save(entity);
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findByUserId(String userId) {
		return userRepository.findUserByUserId(userId);
	}

}
