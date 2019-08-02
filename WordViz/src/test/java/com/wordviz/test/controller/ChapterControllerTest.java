package com.wordviz.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;

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
import com.wordviz.chapter.Chapter;
import com.wordviz.chapter.ChapterController;
import com.wordviz.chapter.ChapterService;
import com.wordviz.story.Story;
import com.wordviz.user.User;

@RunWith(SpringRunner.class)
@WebMvcTest(ChapterController.class)
public class ChapterControllerTest {
	
	@Autowired
	 private ObjectMapper om;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ChapterService service;
	
	@Test
	public void insertChapter() throws JsonProcessingException, Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		Chapter ch = new Chapter(4585, st, "The Frogs Gather", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		mvc.perform(post("/chapter/new")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(ch)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void allChapter() throws Exception {
		mvc.perform(get("/chapter/all")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());	
	}
	
	@Test
	public void updateChapter() throws JsonProcessingException, Exception {
		User u = new User("WillOma", 12345, "WilliamOma");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		Chapter ch = new Chapter(4585, st, "The Frogs Gather", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		mvc.perform(post("/chapter/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(ch)))
				.andExpect(status().isOk());
		
	}

}
