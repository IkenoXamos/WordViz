package com.wordviz.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordviz.user.LoginTemplate;
import com.wordviz.user.User;
import com.wordviz.user.UserController;
import com.wordviz.user.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	 private ObjectMapper om;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService service;
	
	@Test
	public void registerUser() throws Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		mvc.perform(post("/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(u)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void loginTest() throws JsonProcessingException, Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		LoginTemplate lt = new LoginTemplate(u.getUsername(), u.getPassword());
		mvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(lt)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void logoutTest() throws Exception {
		mvc.perform(get("/logout")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	

}
