package com.wordviz.test.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wordviz.user.User;
import com.wordviz.user.UserRepository;
import com.wordviz.user.UserService;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	 @TestConfiguration
	    static class UserServiceTestContextConfiguration {
	  
	        @Bean
	        public UserService userService() {
	            return new UserService();
	        }
	    }
	
	@Autowired
	private UserService us;
	
	@MockBean
	private HttpSession session;
	
	@MockBean
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		User u = new User(1001, "WillOma", 12345, "WilliamOma");
		
		Mockito.when(userRepository.findByUsername(u.getUsername()))
			.thenReturn(u);
	}
	
	@Test
	public void testLogin() {
		String username = "WillOma";
		Integer password = 12345;
		
		User user = us.login(username, password);
		
		assertTrue(user.getUsername().equals("WillOma"));
		verify(userRepository, times(1)).findByUsername(username);
	}
	
	@Test
	public void testLoginWrongPass() {
		String username = "WillOma";
		Integer password = 15555;
		
		User user = us.login(username, password);
		
		assertTrue(user == null);
		verify(userRepository, times(1)).findByUsername(username);
	}
	
	@Test
	public void testLoginWrongUsername() {
		String username = "willOam";
		Integer password = 12345;
		
		User user = us.login(username, password);
		
		assertTrue(user == null);
		verify(userRepository, times(1)).findByUsername(username);
	}
	
	@Test
	public void testRegisterUser() {
		User u = new User("Fram", 155424, "Frances Amar");
		assertTrue(us.register(u));
		verify(userRepository, times(1)).save(u);
		verify(userRepository, times(1)).findByUsername(u.getUsername());
	}
	
	@Test
	public void testRegisterUserAlreadyExists() {
		User u = new User("WillOma", 12345, "WilliamOma");
		assertFalse(us.register(u));
		verify(userRepository, times(0)).save(u);
		verify(userRepository, times(1)).findByUsername(u.getUsername());
	}
	
	
	


}
