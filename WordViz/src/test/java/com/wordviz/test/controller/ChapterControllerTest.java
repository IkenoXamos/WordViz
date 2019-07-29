package com.wordviz.test.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wordviz.chapter.ChapterController;
import com.wordviz.chapter.ChapterService;

@RunWith(SpringRunner.class)
@WebMvcTest(ChapterController.class)
@DataJpaTest
public class ChapterControllerTest {
		
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ChapterService service;
	
	@Test
	public void insertChapter() {
	}
	
	@Test
	public void allChapter() throws Exception {
		mvc.perform(get("/WordViz/chapter/all")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());	
	}

}
