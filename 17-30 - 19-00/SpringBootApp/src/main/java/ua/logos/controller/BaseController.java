package ua.logos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	// @RequestMapping(method = RequestMethod.GET, path = "/")
	@GetMapping(path = "/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/registration")
	public String showRegister() {
		return "register";
	}
	
	@GetMapping("/profile")
	public String showUserProfile() {
		return "user/profile";
	}
	
}
