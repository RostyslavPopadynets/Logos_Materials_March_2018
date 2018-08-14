package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.logos.entity.User;
import ua.logos.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/signin")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userService.signin(username, password);
    }
}
