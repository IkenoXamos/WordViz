package com.wordviz.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}
}
