package com.wordviz.test.models;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.chapter.Chapter;
import com.wordviz.story.Story;
import com.wordviz.tag.Tag;
import com.wordviz.user.User;

public class ChapterTest {

	Chapter c1 = null;
	Chapter c2 = null;

	@Before
	public void setUp() throws Exception {
		c1 = new Chapter(1, new Story(1, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0),
				"name1", "", new Timestamp(10000));
		c2 = new Chapter(2, new Story(2, new User("un2", "pw2".hashCode()), "name2", new ArrayList<Tag>(), 2, 0),
				"name2", "", new Timestamp(20000));
	}

	@Test
	public void testPartialConstructor1() {
		//fail("Not yet implemented");
	}

	@Test
	public void testPartialConstructor2() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFullConstructor() {
		//fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		assertTrue(c1.hashCode() != c2.hashCode());
	}

	@Test
	public void testGetChapterId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetChapterId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetStory() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetStory() {
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
	public void testGetContent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetContent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetTimestamp() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetTimestamp() {
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
