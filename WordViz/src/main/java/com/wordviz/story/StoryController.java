package com.wordviz.story;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/story")
public class StoryController {

	@Autowired
	private StoryRepository storyRepository;
	
	@GetMapping(value = "/all")
	public List<Story> getAllStories() {
		return storyRepository.findAll();
	}
	
	@PostMapping(value = "/new")
	public Story createStory(@RequestBody Story story) {
		return storyRepository.save(story);
	}
}
