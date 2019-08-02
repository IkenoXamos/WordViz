package com.wordviz.test.models;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.tag.Tag;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TagTest {

	private Tag t1 = null;

	@Before
	public void setUp() throws Exception {
		t1 = new Tag(1, "Fiction", 1);
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
		Tag one = new Tag(3, "Development", 2);
		assertTrue(one instanceof Tag);
		Tag two = new Tag(4, "Self Help", 2);
		assertTrue(one != two);
	}

	@Test
	public void testGetTagId() {
		assertTrue(t1.getTagId().equals(1));
	}

	@Test
	public void testSetTagId() {
		t1.setTagId(33);
		assertTrue(t1.getTagId().equals(33));
	}

	@Test
	public void testGetName() {
		assertTrue(t1.getName().equals("Fiction"));
	}

	@Test
	public void testSetName() {
		t1.setName("Adventure");
		assertTrue(t1.getName().equals("Adventure"));
	}
	
	@Test
	public void testGetType() {
		assertTrue(t1.getType().equals(1));
	}

	@Test
	public void testSetType() {
		t1.setType(3);
		assertTrue(t1.getType().equals(3));
	}

	@Test
	public void testEqualsObject() {
		EqualsVerifier.forClass(Tag.class)
		.suppress(Warning.NONFINAL_FIELDS)
		.verify();
	}

	@Test
	public void testToString() {
		assertTrue((t1.toString() instanceof String));
	}
}
