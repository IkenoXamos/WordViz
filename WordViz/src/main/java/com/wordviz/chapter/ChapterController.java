package com.wordviz.chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Chapter")
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;
	
	@PostMapping(value = "/new")
	public Chapter createChapter(@RequestBody Chapter chapter) {
		return chapterService.save(chapter);
	}
	
	@GetMapping(value = "/all")
	public List<Chapter> getAllChapter(){
		return chapterService.findAll();
	}
	
	@PostMapping(value = "/update")
	public Chapter updateChapter(@RequestBody Chapter chapter) {
		return chapterService.update(chapter);
	}
	
	
	
}
