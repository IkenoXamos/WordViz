package com.wordviz.test.models;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.story.Story;
import com.wordviz.tag.Tag;
import com.wordviz.user.User;

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
		//fail("Not yet implemented");
	}

	@Test
	public void testFullConstructor() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testHashCode() {
		assertTrue(s1.hashCode() != s2.hashCode());
	}

	@Test
	public void testGetStoryId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetStoryId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAuthor() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetAuthor() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetType() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetType() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetVote() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetVote() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetTags() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetTags() {
		//fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		//fail("Not yet implemented");
	}
}
