package com.zavada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zavada.domain.mail.Mail;
import com.zavada.service.EmailService;
import com.zavada.service.UserService;

@RestController
public class BaseController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	// localhost:9999/test-message?email=volodymyrzavada@gmail.com
	@GetMapping("test-message")
	public ResponseEntity<Void> sendTestMessage(@RequestParam("email") String email) {
		
		Mail mail = Mail.builder()
					.to(email)
					.subject("Test mail subject")
					.content("Test content")
				.build();
		emailService.sendMessage(mail);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("verify")
	public ResponseEntity<String> verifyAccount(@RequestParam("token") String token) {
		userService.verifyAccount(token);
		return new ResponseEntity<String>("Your account is TRUE", HttpStatus.OK);
	}
	
}
