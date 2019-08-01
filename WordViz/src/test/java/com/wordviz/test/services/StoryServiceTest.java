package com.wordviz.test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wordviz.story.Story;
import com.wordviz.story.StoryRepository;
import com.wordviz.story.StoryService;
import com.wordviz.user.User;
import com.wordviz.user.UserService;

@RunWith(SpringRunner.class)
public class StoryServiceTest {

	@TestConfiguration
    static class UserServiceTestContextConfiguration {
		  
        @Bean
        public StoryService storyService() {
            return new StoryService();
        }
    }
	
	@Autowired
	private StoryService ss;
	
	@MockBean
	private StoryRepository sr;
	
	@Before
	public void setup() {
		User u = new User(1001, "WillOma", 12345, "WilliamOma");
		User u2 = new User(1501, "Fram", 155424, "Frances Amar");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		Story st2 = new Story(1545, u, "Lord of the Frogs The Second Frogging", null, 1, 0);
		Story st3 = new Story(2555, u, "Lord of the Frogs The Frogger", null, 1, 0);
		Story st4 = new Story(554, u2, "The Fran knight rises", null, 1, 0);
		Story st5 = new Story(2556, u2, "The Fran knight", null, 1, 0);
		List<Story> allStory = new ArrayList<Story>();
		allStory.add(st);
		allStory.add(st2);
		allStory.add(st3);
		allStory.add(st4);
		List<Story> willStory = new ArrayList<Story>();
		allStory.add(st);
		allStory.add(st2);
		allStory.add(st3);
		List<Story> franStory = new ArrayList<Story>();
		franStory.add(st4);
		
		Optional<Story> sto = Optional.of(st);
		Optional<Story> sto2 = Optional.of(st2);
		
		Mockito.when(sr.findAllByOrderByStoryIdAsc()).thenReturn(allStory);
		Mockito.when(sr.findByName(st.getName())).thenReturn(st);
		Mockito.when(sr.findByName(st2.getName())).thenReturn(st2);
		Mockito.when(sr.findByName(st4.getName())).thenReturn(st4);
		Mockito.when(sr.findById(st.getStoryId())).thenReturn(sto);
		Mockito.when(sr.findById(st2.getStoryId())).thenReturn(sto2);
		Mockito.when(sr.findByAuthorOrderByStoryIdAsc(u)).thenReturn(willStory);
		Mockito.when(sr.findByAuthorOrderByStoryIdAsc(u2)).thenReturn(franStory);
		Mockito.when(sr.save(st5)).thenReturn(st5);
		
	}
	
	@Test
	public void getAllTest() {
		ss.findAll();
		verify(sr, times(1)).findAllByOrderByStoryIdAsc();
	}
	
	@Test
	public void findByName() {
		ss.findByName("Lord of the Frogs");
		verify(sr, times(1)).findByName("Lord of the Frogs");
		verify(sr, times(0)).findAll();
		verify(sr, times(0)).findByName("Lord of the Frogs The Second Frogging");
	}
	
	@Test
	public void findByAuthor() {
		User u = new User(1001, "WillOma", 12345, "WilliamOma");
		User u2 = new User(1501, "Fram", 155424, "Frances Amar");
		ss.findByAuthor(u);
		verify(sr, times(1)).findByAuthorOrderByStoryIdAsc(u);
		verify(sr, times(0)).findByAuthorOrderByStoryIdAsc(u2);
	}
	
	@Test
	public void findById() {
		ss.findById(418);
		verify(sr, times(1)).findById(418);
		verify(sr, times(0)).findById(1545);
		verify(sr, times(0)).findAll();
		
	}
	
	@Test
	public void save() {
		User u2 = new User(1501, "Fram", 155424, "Frances Amar");
		Story st5 = new Story(2556, u2, "The Fran knight", null, 1, 0);
		ss.save(st5);
		verify(sr, times(1)).save(st5);
		verify(sr, times(0)).findAll();
		verify(sr, times(0)).findById(st5.getStoryId());
		verify(sr, times(0)).findByName(st5.getName());
	}
	

}
