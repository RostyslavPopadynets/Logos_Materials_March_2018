package com.zavada.service.impl;

import static com.zavada.constants.ErrorMessages.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zavada.config.jwt.JWTTokenProvider;
import com.zavada.domain.UserDTO;
import com.zavada.domain.mail.Mail;
import com.zavada.entity.UserEntity;
import com.zavada.entity.enums.UserRole;
import com.zavada.exceptions.UserServiceException;
import com.zavada.repository.UserRepository;
import com.zavada.service.EmailService;
import com.zavada.service.UserService;
import com.zavada.service.utils.ObjectMapperUtils;
import com.zavada.service.utils.StringUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ObjectMapperUtils objectMapper;

	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private EmailService emailService;

	@Autowired
	private StringUtils stringUtils;

	@Override
	public void save(UserDTO dto) {

		String verifyToken = stringUtils.generate(100);

		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new UserServiceException(RECORD_ALREADY_EXISTS);
		} else {
			dto.setRole(UserRole.ROLE_USER);
			System.out.println("Password:" + dto.getPassword());
			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			System.out.println("Password2:" + dto.getPassword());

			UserEntity userEntity = objectMapper.map(dto, UserEntity.class);
			userEntity.setEmailVerificationToken(verifyToken);
			userEntity.setEmailVerificationStatus(Boolean.FALSE);

			userRepository.save(userEntity);
			sendEmail(dto.getEmail(), verifyToken);
		}
	}

	private void sendEmail(String email, String verifyToken) {
		//String verifyUrl = "http://localhost:9999/verify?token=" + verifyToken;
		String verifyUrl = getHostName() + "verify?token=" + verifyToken;

		Mail mail = new Mail();
		mail.setTo(email);
		mail.setSubject("You are succesfully registered");
		mail.setContent("Please verify your account follow the link: " + verifyUrl);

		emailService.sendMessage(mail);
	}
	
	private String getHostName() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		
		// http://localhost:9999/
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
	}

	@Override
	public void verifyAccount(String verifyToken) {
		UserEntity userEntity = userRepository.findByEmailVerificationToken(verifyToken);
		if(userEntity != null) {
			userEntity.setEmailVerificationToken(null);
			userEntity.setEmailVerificationStatus(Boolean.TRUE);
			userRepository.save(userEntity);
		}
	}

	@Override
	public String signin(String username, String password) {
		System.out.println(">>> " + username);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		System.out.println(">>> " + username);
		return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRole());
	}

	@Override
	public UserDTO findById(Long id) {
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		return null;
	}

	@Override
	public boolean existsByUsername(String username) {
		return false;
	}

	@Override
	public UserDTO findByUsername(String username) {
		return objectMapper.map(userRepository.findByUsername(username), UserDTO.class);
	}
}
