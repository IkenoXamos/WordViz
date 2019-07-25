package com.wordviz.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserRepository userRepository;
	
	public User login(User user) {
		if(!session.isNew()) {
			logout();
		}
		
		User u = userRepository.findByUsername(user.getUsername());
		
		if(u.getPassword().equals(user.getPassword())) {
			session.setAttribute("currentUser", user);
			return u;
		} else {
			return null;
		}
	}
	
	public void logout() {
		session.removeAttribute("currentUser");
	}
	
	public Boolean register(User user) {
		if(usernameExists(user.getUsername())) {
			return false;
		} else {
			userRepository.save(user);
			return true;
		}
	}
	
	private boolean usernameExists(String username) {
		return (userRepository.findByUsername(username) != null);
	}
}
