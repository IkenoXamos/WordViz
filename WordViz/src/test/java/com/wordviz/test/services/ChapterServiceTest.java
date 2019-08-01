package com.wordviz.test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wordviz.chapter.Chapter;
import com.wordviz.chapter.ChapterRepository;
import com.wordviz.chapter.ChapterService;
import com.wordviz.story.Story;
import com.wordviz.user.User;

@RunWith(SpringRunner.class)
public class ChapterServiceTest {

	@TestConfiguration
    static class ChapterServiceTestContextConfiguration {
		  
        @Bean
        public ChapterService chapterService() {
            return new ChapterService();
        }
    }
	
	@Autowired
	private ChapterService cs;
	
	@MockBean
	private ChapterRepository cr;
	
	@Before
	public void setup() {
		User u = new User("WillOma", 12345, "WilliamOma");
		User u2 = new User(1501, "Fram", 155424, "Frances Amar");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		Story st2 = new Story(554, u2, "The Fran knight rises", null, 1, 0);
		Chapter ch = new Chapter(4585, st, "The Frogs Gather", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		Chapter ch2 = new Chapter(4590, st, "The Frogs Gather", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		Chapter ch3 = new Chapter(4652, st, "The Frogs Gather", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		Chapter ch4 = new Chapter(5521, st2, "The Fran Knight", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		Chapter ch5 = new Chapter(5564, st2, "The Great Compromise", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		List<Chapter> LotFChapters = new ArrayList<Chapter>();
		List<Chapter> TFNRChapters = new ArrayList<Chapter>();
		List<Chapter> allChapters = new ArrayList<Chapter>();
		LotFChapters.add(ch);
		LotFChapters.add(ch2);
		LotFChapters.add(ch3);
		TFNRChapters.add(ch4);
		allChapters.add(ch);
		allChapters.add(ch2);
		allChapters.add(ch3);
		allChapters.add(ch4);
		
		Mockito.when(cr.findAllByOrderByTimestampAsc()).thenReturn(allChapters);
		Mockito.when(cr.findByStoryOrderByChapterIdAsc(st)).thenReturn(LotFChapters);
		Mockito.when(cr.findByStoryOrderByChapterIdAsc(st2)).thenReturn(TFNRChapters);
		Mockito.when(cr.save(ch5)).thenReturn(ch5);
		
	}
	
	@Test
	public void findAll() {
		cs.findAll();
		verify(cr, times(1)).findAllByOrderByTimestampAsc();
	}
	
	@Test
	public void findByStory() {
		User u = new User("WillOma", 12345, "WilliamOma");
		User u2 = new User(1501, "Fram", 155424, "Frances Amar");
		Story st = new Story(418, u, "Lord of the Frogs", null, 1, 0);
		Story st2 = new Story(554, u2, "The Fran knight rises", null, 1, 0);
		cs.findByStory(st);
		verify(cr, times(1)).findByStoryOrderByChapterIdAsc(st);
		verify(cr, times(0)).findByStoryOrderByChapterIdAsc(st2);
	}
	
	@Test
	public void save() {
		User u2 = new User(1501, "Fram", 155424, "Frances Amar");
		Story st2 = new Story(554, u2, "The Fran knight rises", null, 1, 0);
		Chapter ch5 = new Chapter(5564, st2, "The Great Compromise", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		cs.save(ch5);
		verify(cr, times(1)).save(ch5);
	}
	
	public void update() {
		User u2 = new User(1501, "Fram", 155424, "Frances Amar");
		Story st2 = new Story(554, u2, "The Fran knight rises", null, 1, 0);
		Chapter ch5 = new Chapter(5564, st2, "The Great Compromise", "IT all started blah blah blah", new Timestamp(System.currentTimeMillis()));
		cs.save(ch5);
		verify(cr, times(1)).save(ch5);
	}

}
