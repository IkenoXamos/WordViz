package com.wordviz.story;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.wordviz.tag.Tag;
import com.wordviz.user.User;

@Entity
@Table(name = "story")
public class Story {

	@Id
	@GeneratedValue
	@Column(name = "storyId")
	private Integer storyId;

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "author")
	private User author;

	@NotNull
	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(
			name = "storyTagsJT",
			joinColumns = @JoinColumn(name = "storyId"),
			inverseJoinColumns = @JoinColumn(name = "tagId"))
	private List<Tag> tags;

	@NotNull
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "vote")
	private Integer vote;
	
	public Story() {
		this.name = "";
		this.type = 1;
	}

	public Story(User author, String name, Integer type) {
		this.author = author;
		this.name = name;
		this.type = type;
	}

	public Story(Integer storyId, User author, String name, List<Tag> tags, Integer type, Integer vote) {
		this.storyId = storyId;
		this.author = author;
		this.name = name;
		this.tags = tags;
		this.type = type;
		this.vote = vote;
	}

	public Integer getStoryId() {
		return storyId;
	}

	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
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
	
	@Override
	public String toString() {
		return "Story [storyId=" + storyId + ", author=" + author + ", name=" + name + ", tags=" + tags + ", type="
				+ type + ", vote=" + vote + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((storyId == null) ? 0 : storyId.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
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
}
