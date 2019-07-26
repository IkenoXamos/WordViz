package com.wordviz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	public User login(@RequestBody String username, @RequestBody Integer password) {
		return userService.login(username, password);
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
