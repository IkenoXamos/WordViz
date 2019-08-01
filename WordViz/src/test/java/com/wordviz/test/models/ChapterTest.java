package com.wordviz.test.models;

import static org.junit.Assert.assertFalse;
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
		Chapter one = new Chapter(new Story(1, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0),
				"name1", "", new Timestamp(10000));
		assertTrue(one instanceof Chapter);
		Chapter two = new Chapter(new Story(2, new User("un2", "pw2".hashCode()), "name2", new ArrayList<Tag>(), 2, 0),
				"name2", "", new Timestamp(20000));
		assertTrue(one != two);
	}

	@Test
	public void testPartialConstructor2() {
		Chapter one = new Chapter(new Story(1, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0), 
				new Timestamp(10000));
		assertTrue(one instanceof Chapter);
		Chapter two = new Chapter(new Story(2, new User("un2", "pw2".hashCode()), "name2", new ArrayList<Tag>(), 2, 0),
				new Timestamp(20000));
		assertTrue(one != two);
	}

	@Test
	public void testFullConstructor() {
		Chapter one = new Chapter(1, new Story(1, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0),
				"name1", "", new Timestamp(10000));
		assertTrue(one instanceof Chapter);
		Chapter two = new Chapter(2, new Story(2, new User("un2", "pw2".hashCode()), "name2", new ArrayList<Tag>(), 2, 0),
				"name2", "", new Timestamp(20000));
		assertTrue(one != two);
	}

	@Test
	public void testHashCode() {
		assertTrue(c1.hashCode() != c2.hashCode());
	}

	@Test
	public void testGetChapterId() {
		assertTrue(c1.getChapterId().equals(1));
	}

	@Test
	public void testSetChapterId() {
		c1.setChapterId(1251);
		assertTrue(c1.getChapterId().equals(1251));
	}

	@Test
	public void testGetStory() {
		Story temp = new Story(1, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0);
		assertTrue(c1.getStory().equals(temp));
	}

	@Test
	public void testSetStory() {
		Story temp = new Story(24, new User("un1", "pw1".hashCode()), "name1", new ArrayList<Tag>(), 1, 0);
		c1.setStory(temp);
		assertTrue(c1.getStory().equals(temp));
	}

	@Test
	public void testGetName() {
		assertTrue(c1.getName().equals("name1"));
	}

	@Test
	public void testSetName() {
		c1.setName("True Name");
		assertTrue(c1.getName().equals("True Name"));
	}

	@Test
	public void testGetContent() {
		assertTrue(c1.getContent().equals(""));
	}

	@Test
	public void testSetContent() {
		c1.setContent("Content");
		assertTrue(c1.getContent().equals("Content"));
	}

	@Test
	public void testGetTimestamp() {
		assertTrue(c1.getTimestamp().equals(new Timestamp(10000)));
	}

	@Test
	public void testSetTimestamp() {
		c1.setTimestamp(new Timestamp(50000));
		assertTrue(c1.getTimestamp().equals(new Timestamp(50000)));
	}

	@Test
	public void testToString() {
		assertTrue((c1.toString() instanceof String));
	}

	@Test
	public void testEqualsObject() {
		Chapter temp = new Chapter(2, new Story(2, new User("un2", "pw2".hashCode()), "name2", new ArrayList<Tag>(), 2, 0),
				"name2", "", new Timestamp(20000));
		assertTrue(c2.equals(temp));
		assertFalse(c2.equals(c1));
	}
}
