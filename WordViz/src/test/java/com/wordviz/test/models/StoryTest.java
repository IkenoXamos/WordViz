package com.wordviz.test.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.story.Story;
import com.wordviz.tag.Tag;
import com.wordviz.user.User;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class StoryTest {
	
	Story s1 = null;
	Story s2 = null;

	@Before
	public void setUp() throws Exception {
		s1 = new Story(1, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0);
		s2 = new Story(2, new User("un2", "pw2".hashCode()), "name2", new ArrayList<Tag>(), 2, 0);
	}

	@Test
	public void testPartialConstructor() {
		Story one = new Story(new User("un1", "pw1".hashCode()), "name1", 1);
		assertTrue(one instanceof Story);
		Story two = new Story(new User("un2", "pw2".hashCode()), "name2", 2);
		assertTrue(one != two);
	}

	@Test
	public void testFullConstructor() {
		Story one = new Story(1, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0);
		assertTrue(one instanceof Story);
		Story two = new Story(2, new User("un2", "pw2".hashCode()), "name2", new ArrayList<Tag>(), 2, 0);
		assertTrue(one != two);
	}
	
	@Test
	public void testGetStoryId() {
		assertTrue(s1.getStoryId().equals(1));
	}

	@Test
	public void testSetStoryId() {
		s1.setStoryId(45);
		assertTrue(s1.getStoryId().equals(45));
	}

	@Test
	public void testGetAuthor() {
		User temp = new User("un1", "pw1".hashCode());
		assertTrue(s1.getAuthor().equals(temp));
	}

	@Test
	public void testSetAuthor() {
		User temp = new User("un2", "pass1".hashCode());
		s1.setAuthor(temp);
		assertTrue(s1.getAuthor().equals(temp));
	}

	@Test
	public void testGetName() {
		assertTrue(s1.getName().equals("name1"));
	}

	@Test
	public void testSetName() {
		s1.setName("True Name");
		assertTrue(s1.getName().equals("True Name"));
	}

	@Test
	public void testGetType() {
		assertTrue(s1.getType().equals(1));
	}

	@Test
	public void testSetType() {
		s1.setType(3);
		assertTrue(s1.getType().equals(3));
	}

	@Test
	public void testGetVote() {
		assertTrue(s1.getVote().equals(0));
	}

	@Test
	public void testSetVote() {
		s1.setVote(9001);
		assertTrue(s1.getVote().equals(9001));
	}

	@Test
	public void testGetTags() {
		List<Tag> tags = new ArrayList<Tag>();
		assertTrue(s1.getTags().equals(tags));
	}

	@Test
	public void testSetTags() {
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(new Tag(1, "Fiction", 1));
		s1.setTags(tags);
		assertTrue(s1.getTags().equals(tags));
	}

	@Test
	public void testToString() {
		assertTrue((s1.toString() instanceof String));
	}

	@Test
	public void testEqualsObject() {
		EqualsVerifier.forClass(Story.class)
			.suppress(Warning.NONFINAL_FIELDS)
			.verify();
		
	}
}
