package ua.logos.controller;

import java.util.ArrayList;
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

import ua.logos.domain.dto.UserDTO;
import ua.logos.entity.UserEntity;
import ua.logos.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired private UserService userService;	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveUser(@RequestBody UserDTO userDTO) {
		
		UserEntity entity = UserEntity
				.builder()
					.firstName(userDTO.getFirstName())
					.lastName(userDTO.getLastName())
					.email(userDTO.getEmail())
					.password(userDTO.getPassword())
				.build();
		userService.create(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{user-id}")
	public ResponseEntity<UserDTO> getUserById(
			@PathVariable("user-id") String id) {
		
		UserEntity entity = userService.findByUserId(id);
		
		UserDTO dto = UserDTO
				.builder()
					.userId(entity.getUserId())
					.firstName(entity.getFirstName())
					.lastName(entity.getLastName())
					.email(entity.getEmail())
				.build();
		
		return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserEntity> entities = userService.findAll();
		List<UserDTO> userDTOs = new ArrayList<>();
		
		for (int i = 0; i < entities.size(); i++) {
			UserDTO dto = UserDTO
					.builder()
						.userId(entities.get(i).getUserId())
						.firstName(entities.get(i).getFirstName())
						.lastName(entities.get(i).getLastName())
						.email(entities.get(i).getEmail())
					.build();
			userDTOs.add(dto);
		}
		
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}
	
}
