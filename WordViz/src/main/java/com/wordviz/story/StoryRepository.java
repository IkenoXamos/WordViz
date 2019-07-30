package com.wordviz.story;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import com.wordviz.user.User;

public interface StoryRepository extends JpaRepository<Story, Integer> {
	
	@Nullable
	List<Story> findAllByOrderByStoryIdAsc();

	@Nullable
	List<Story> findByAuthorOrderByStoryIdAsc(User author);
	
	@Nullable
	Story findByName(String name);
	
	@Nullable
	List<Story> findByTypeOrderByStoryIdAsc(Integer type);
}
