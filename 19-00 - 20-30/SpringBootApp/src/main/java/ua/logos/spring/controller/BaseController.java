package ua.logos.spring.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	//@RequestMapping(method = HttpMethod.GET)
	//@GetMapping(path = "/")
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/news")
	public String showNews() {
		return "news-page";
	}
	
	@GetMapping("/services")
	public String showServices() {
		return "service";
	}
	
}
