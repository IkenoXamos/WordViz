package com.wordviz.test.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordviz.chapter.ChapterService;
import com.wordviz.story.Story;
import com.wordviz.story.StoryController;
import com.wordviz.story.StoryService;
import com.wordviz.user.User;
import com.wordviz.user.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(StoryController.class)
public class StoryControllerTest {

	@Autowired
	 private ObjectMapper om;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private StoryService service;
	
	@MockBean
	private ChapterService cService;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getAllStoriesTest() throws Exception {
		mvc.perform(get("/story/all")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void newStoryTest() throws JsonProcessingException, Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		mvc.perform(post("/story/new")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(st)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void updateStoryTest() throws JsonProcessingException, Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		mvc.perform(post("/story/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(st)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void chaptersStoryTest() throws JsonProcessingException, Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		mvc.perform(post("/story/chapters")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(st)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void userStoryTest() throws JsonProcessingException, Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		mvc.perform(post("/story/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(u)))
				.andExpect(status().isOk());
	}

}
