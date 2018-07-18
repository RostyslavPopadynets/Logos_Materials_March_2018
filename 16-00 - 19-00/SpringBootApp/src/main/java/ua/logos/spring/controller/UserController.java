package ua.logos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.logos.spring.entity.UserEntity;
import ua.logos.spring.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/add-user")
	public String showAddUserForm() {
		return "user/add-user";
	}

	@PostMapping("/add-user-save")
	public String saveUser(@RequestParam("first") String first, @RequestParam("last") String lastN,
			@RequestParam("email") String email) {
		System.out.println("fName: " + first);
		System.out.println("lName: " + lastN);
		System.out.println("eail: " + email);

		// UserEntity userEntity = new UserEntity();
		// userEntity.setFirstName(first);
		// userEntity.setLastName(lastN);
		// userEntity.setEmail(email);

		UserEntity user = UserEntity
				.builder()
					.firstName(first)
					.lastName(lastN)
					.email(email)
				.build();

		userService.save(user);
		
		return "redirect:/users/list";
	}
	
	@GetMapping("/list")
	public String usersList(Model model) {
		
		List<UserEntity> entities = userService.findAll();
		model.addAttribute("usersListFromDB", entities);
		
		return "user/list";
	}
	
	@GetMapping("/profile/{userId}")
	public String showProfile(
			@PathVariable("userId") Long id,
			@RequestParam("user_email") String email,
			Model model
			) {
		
		System.out.println("User ID: " + id);
		System.out.println("User Email: " + email);
		
		UserEntity user = userService.findById(id);
		model.addAttribute("userProfile", user);
		
		return "user/profile";
	}
	
	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Long id) {
		userService.delete(id);
		return "redirect:/users/list";
	}

}
