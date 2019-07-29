package com.wordviz.story;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordviz.chapter.Chapter;
import com.wordviz.chapter.ChapterService;
import com.wordviz.user.UserRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/story")
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/all")
	public List<Story> getAllStories() {
		return storyService.findAll();
	}
	
	@PostMapping(value = "/new")
	public Story createStory(@RequestBody Story story) {
		userRepository.save(story.getAuthor());
		return storyService.save(story);
	}
	
	@PostMapping(value = "/chapters")
	public List<Chapter> getChapters(@RequestBody Story story) {
		return chapterService.findByStory(story);
	}
}
