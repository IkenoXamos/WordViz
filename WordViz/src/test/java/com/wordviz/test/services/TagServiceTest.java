package com.wordviz.test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

import com.wordviz.tag.Tag;
import com.wordviz.tag.TagRepository;
import com.wordviz.tag.TagService;
import com.wordviz.user.UserService;

@RunWith(SpringRunner.class)
public class TagServiceTest {

	 @TestConfiguration
	    static class TagServiceTestContextConfiguration {
	  
	        @Bean
	        public TagService tagService() {
	            return new TagService();
	        }
	    }
	 
	 @Autowired
	 private TagService ts;
	 
	 @MockBean
	 private TagRepository tr;
	 
	 @Before
	 public void setup() {
		Tag tag = new Tag("Adventure", 1);
		List<Tag> storyTags = new ArrayList<Tag>();
		storyTags.add(new Tag(1, "Drama", 1));
		storyTags.add(new Tag(2, "Comedy", 1));
		storyTags.add(new Tag(3, "Horror", 1));
		storyTags.add(new Tag(4, "Fantasy", 1));
		storyTags.add(new Tag(5, "Hitorical", 1));
		storyTags.add(new Tag(6, "Mystory", 1));
		 
		List<Tag> blogTags = new ArrayList<Tag>();
		blogTags.add(new Tag(14, "Development", 2));
		blogTags.add(new Tag(15, "Daily", 2));
		blogTags.add(new Tag(16, "Travel", 2));
		blogTags.add(new Tag(17, "Food", 2));
		blogTags.add(new Tag(18, "Technology", 2));
		 
		List<Tag> all = new ArrayList<Tag>();
		all.add(new Tag(1, "Drama", 1));
		all.add(new Tag(2, "Comedy", 1));
		all.add(new Tag(3, "Horror", 1));
		all.add(new Tag(4, "Fantasy", 1));
		all.add(new Tag(5, "Hitorical", 1));
		all.add(new Tag(6, "Mystory", 1));
		all.add(new Tag(14, "Development", 2));
		all.add(new Tag(15, "Daily", 2));
		all.add(new Tag(16, "Travel", 2));
		all.add(new Tag(17, "Food", 2));
		all.add(new Tag(18, "Technology", 2));
		
		Mockito.when(tr.findAll()).thenReturn(all);
		Mockito.when(tr.findByType(1)).thenReturn(storyTags);
		Mockito.when(tr.findByType(2)).thenReturn(blogTags);
		Mockito.when(tr.findByType(3)).thenReturn(null);
		Mockito.when(tr.save(tag)).thenReturn(tag);
	 }
	 
	 @Test
	 public void findAllTest() {
		 List<Tag> tags = ts.findAll();
		 verify(tr, times(1)).findAll();
		 verify(tr, times(0)).findByType(1);
	 }
	 
	 @Test
	 public void findAllStoryTest() {
		 List<Tag> tags = ts.findByType(1);
		 verify(tr, times(1)).findByType(1);
		 verify(tr, times(0)).findAll();
		 verify(tr, times(0)).findByType(3);
	 }
	 
	 @Test
	 public void findAllBlogsTest() {
		 List<Tag> tags = ts.findByType(2);
		 verify(tr,times(1)).findByType(2);
		 verify(tr, times(0)).findByType(1);
		 verify(tr, times(0)).findAll();
	 }
	 
	 @Test
	 public void findAllTypeRandom() {
		 List<Tag> tags = ts.findByType(3);
		 verify(tr, times(1)).findByType(3);
		 verify(tr, times(0)).findByType(1);
		 verify(tr, times(0)).findAll();
	 }
	 
	 @Test
	 public void addTags() {
		 Tag tag = new Tag("Adventure", 1);
		 Tag test = ts.save(tag);
		 verify(tr, times(1)).save(tag);
		 verify(tr, times(0)).findByType(1);
		 verify(tr, times(0)).findAll();
	 }
}
