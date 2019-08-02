package com.wordviz.chapter;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.wordviz.story.Story;

@Entity
@Table(name = "chapter")
public class Chapter {

	@Id
	@GeneratedValue
	@Column(name = "chapterId")
	private Integer chapterId;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "storyId")
	private Story story;
	
	@Size(max = 50)
	@Column(name = "name")
	private String name;
	
	@Lob
	@Column(name = "content", columnDefinition = "CLOB")
	private String content;
	
	@UpdateTimestamp
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	public Chapter() {
		super();
	}
	
	public Chapter(@NotNull Story story, Timestamp timestamp) {
		this.story = story;
		this.timestamp = timestamp;
	}

	public Chapter(@NotNull Story story, @Size(max = 50) String name, String content, Timestamp timestamp) {
		this.story = story;
		this.name = name;
		this.content = content;
		this.timestamp = timestamp;
	}

	public Chapter(Integer chapterId, @NotNull Story story, @Size(max = 50) String name, String content,
			Timestamp timestamp) {
		this.chapterId = chapterId;
		this.story = story;
		this.name = name;
		this.content = content;
		this.timestamp = timestamp;
	}

	public Integer getChapterId() {
		return chapterId;
	}
	
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
	
	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", story=" + story + ", name=" + name + ", content=" + content
				+ ", timestamp=" + timestamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((story == null) ? 0 : story.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Chapter))
			return false;
		Chapter other = (Chapter) obj;

		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
}
