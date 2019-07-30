package com.wordviz.test.controller;

import static org.junit.Assert.*;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordviz.tag.TagController;
import com.wordviz.tag.TagService;


@RunWith(SpringRunner.class)
@WebMvcTest(TagController.class)
public class TagControllerTest {

	@Autowired
	 private ObjectMapper om;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TagService service;
	
	@Test
	public void newTag() throws Exception {
		mvc.perform(post("/tag/new")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString("Fiction")))
				.andExpect(status().isOk());
	}
	
	@Test
	public void allTags() throws Exception {
		mvc.perform(get("/tag/all")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
