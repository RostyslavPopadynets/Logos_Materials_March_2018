package ua.logos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("news")
public class NewsController {

	@GetMapping({"/", ""}) // localhost:8080/news
	public String showNews() {
		return "news/news";
	}
	
	@GetMapping("{newsId}") // localhost:8080/news/{1, 2, 4, 12}
	public String showNewsById(
			@PathVariable("newsId") Long id, Model model
			) {
		System.out.println("News ID: " + id);
		
		model.addAttribute("newsIdKey", id);
		
		return "news/news-preview";
	}
	
	@GetMapping("/add")
	public String showAddNewsForm() {
		return "news/add-news";
	}
	
	@PostMapping("/add")
	public String addNews(
			@RequestParam("title") String newsTitle,
			@RequestParam("description") String newsDescription
			) {
		System.out.println("News title: " + newsTitle);
		System.out.println("News description: " + newsDescription);
		return "redirect:/news";
	}
	
	// localhost:8080/news/{1..1000}/news/{1..1000}?name=John
	@GetMapping("{userId}/news/{newsId}")
	public String getNewsAuthor(
			@PathVariable("userId") Long id,
			@PathVariable("newsId") Long newsId,
			@RequestParam(name = "name", required = false) String name
			) {
		
		System.out.println("User id: " + id);
		System.out.println("News id: " + newsId);
		System.out.println("Author name: " + name);
		
		return "news/news";
	}
	
}
