package com.wordviz.test.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wordviz.user.UserController;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@DataJpaTest
public class StoryControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
