package com.wordviz.tag;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@PostMapping(value = "/new")
	public Tag createTag(@RequestBody Tag tag) {
		return tagService.save(tag);
	}
	
	@GetMapping(value = "/all")
	public List<Tag> getAllTags(){
		return tagService.findAll();
	}
	
	@GetMapping(value = "/{type}")
	public List<Tag> getByType(@PathVariable String type) {
		if(type.equals("story")) {
			return tagService.findByType(1);
		} else if(type.equals("blog")) {
			return tagService.findByType(2);
		} else {
			return new ArrayList<>();
		}
	}
}
