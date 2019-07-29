package com.wordviz.story;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {
	
	@Autowired
	StoryRepository storyRepository;

	public Story save(Story story) {
		return storyRepository.save(story);
	}

	public List<Story> findAll() {
		return storyRepository.findAll();
	}
	
	public Story findByName(String name) {
		return storyRepository.findByName(name);
	}
	
	public Story findById(Integer id) {
		Optional<Story> tmp = storyRepository.findById(id);
		return (tmp.isPresent()) ? tmp.get() : null;
	}
}
