package com.wordviz.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.models.Tag;

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
	public void testTag() {
		fail("Not yet implemented");
	}

	@Test
	public void testTagString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTagIntegerString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTagId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTagId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
