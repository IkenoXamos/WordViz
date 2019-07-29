package com.wordviz.test.models;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.tag.Tag;

public class TagTest {

	private Tag t1 = null;
	private Tag t2 = null;

	@Before
	public void setUp() throws Exception {
		t1 = new Tag(1, "Fiction");
		t2 = new Tag(2, "Non-Fiction");
	}

	@Test
	public void testHashCode() {
		assertTrue(t1.hashCode() != t2.hashCode());
	}

	@Test
	public void testPartialConstructor() {
		Tag one = new Tag("Development");
		assertTrue(one instanceof Tag);
		Tag two = new Tag("Self Help");
		assertTrue(one != two);
	}

	@Test
	public void testFullConstructor() {
		Tag one = new Tag(3, "Development");
		assertTrue(one instanceof Tag);
		Tag two = new Tag(4, "Self Help");
		assertTrue(one != two);
	}

	@Test
	public void testGetTagId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetTagId() {
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
	public void testEqualsObject() {
		//fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
	}
}
