package com.wordviz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	public User login(@RequestBody User user) {
		return userService.login(user);
	}
	
	@GetMapping(value = "/logout")
	public void logout() {
		userService.logout();
	}
	
	@PostMapping(value = "/register")
	public Boolean register(@RequestBody User user) {
		return userService.register(user);
	}
}
