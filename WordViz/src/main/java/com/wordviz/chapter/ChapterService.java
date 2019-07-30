package com.wordviz.chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wordviz.story.Story;

@Service
public class ChapterService {
	
	@Autowired
	private ChapterRepository chapterRepository;

	public Chapter save(Chapter chapter) {
		return chapterRepository.save(chapter);
	}

	public List<Chapter> findAll() {
		return chapterRepository.findAllOrderByTimestamp();
	}
	
	public List<Chapter> findByStory(Story story) {
		return chapterRepository.findByStoryOrderByChapterId(story);
	}

	public Chapter update(Chapter chapter) {
		return chapterRepository.save(chapter);
	}
}
