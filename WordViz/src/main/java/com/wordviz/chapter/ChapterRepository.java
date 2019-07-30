package com.wordviz.chapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wordviz.story.Story;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
	
	List<Chapter> findAllOrderByTimestamp();
	
	List<Chapter> findByStoryOrderByChapterId(Story story);

}
