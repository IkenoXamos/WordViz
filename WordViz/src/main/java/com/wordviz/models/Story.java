package com.wordviz.models;

import java.io.Serializable;
import java.util.List;

public class Story implements Serializable {

	private static final long serialVersionUID = -5036618377447956825L;
	private Integer storyId;
	private Integer author;
	private String name;
	private List<Tag> tags;
	private Integer type;
	private Integer vote;
	
	public Story() {
		super();
	}
	
	public Story(Integer storyId, Integer author, String name, List<Tag> tags, Integer type, Integer vote) {
		super();
		this.storyId = storyId;
		this.author = author;
		this.name = name;
		this.tags = tags;
		this.type = type;
		this.vote = vote;
	}

	
	public Story(Integer author, String name, List<Tag> tags, Integer type) {
		super();
		this.author = author;
		this.name = name;
		this.tags = tags;
		this.type = type;
	}

	@Override
	public String toString() {
		return "story [storyId=" + storyId + ", author=" + author + ", name=" + name + ", type=" + type + ", vote="
				+ vote + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((storyId == null) ? 0 : storyId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vote == null) ? 0 : vote.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (storyId == null) {
			if (other.storyId != null)
				return false;
		} else if (!storyId.equals(other.storyId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vote == null) {
			if (other.vote != null)
				return false;
		} else if (!vote.equals(other.vote))
			return false;
		return true;
	}
	public Integer getStoryId() {
		return storyId;
	}
	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getVote() {
		return vote;
	}
	public void setVote(Integer vote) {
		this.vote = vote;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
}
