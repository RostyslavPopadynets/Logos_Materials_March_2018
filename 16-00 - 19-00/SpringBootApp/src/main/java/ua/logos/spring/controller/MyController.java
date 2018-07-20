package ua.logos.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	// localhost:8080
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	
	// http://localhost:8080/news
	@GetMapping("/news")
	public String showNews() {
		return "news";
	}
}