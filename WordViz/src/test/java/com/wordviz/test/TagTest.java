package com.wordviz.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.models.Tag;
import com.wordviz.models.User;

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
	public void testEmptyConstructor() {
		assertTrue(new Tag() instanceof Tag);
		assertFalse(null instanceof Tag);
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
