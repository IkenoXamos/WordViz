package com.wordviz.story;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class StoryService {
	
	@Autowired
	StoryRepository storyRepository;

	public Story save(Story story) {
		return storyRepository.save(story);
	}

	public List<Story> findAll() {
		return storyRepository.findAll();
	}
	

}
