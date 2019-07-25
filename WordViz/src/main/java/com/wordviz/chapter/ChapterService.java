package com.wordviz.chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ChapterService {
	
	@Autowired
	private ChapterRepository chapterRepository;

	public Chapter save(Chapter chapter) {
		return chapterRepository.save(chapter);
	}

	public List<Chapter> findAll() {
		return chapterRepository.findAll();
	}

	public Chapter update(Chapter chapter) {
		return chapterRepository.save(chapter);
	}

}
