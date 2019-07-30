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
		return chapterRepository.findAllByOrderByTimestampAsc();
	}
	
	public List<Chapter> findByStory(Story story) {
		return chapterRepository.findByStoryOrderByChapterIdAsc(story);
	}

	public Chapter update(Chapter chapter) {
		return chapterRepository.save(chapter);
	}
}
