package com.wordviz.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.models.User;

public class UserTest {
	
	private User u1 = null;
	private User u2 = null;

	@Before
	public void setUp() throws Exception {
		u1 = new User(1, "un1", "pw1".hashCode(), "dn1");
		u2 = new User(2, "un2", "pw2".hashCode(), "dn2");
	}

	@Test
	public void testEmptyConstructor() {
		assertTrue(new User() instanceof User);
		assertFalse(null instanceof User);
	}

	@Test
	public void testPartialConstructor1() {
		User one = new User("un1", "pw1".hashCode());
		assertTrue(one instanceof User);
		User two = new User("un2", "pw2".hashCode());
		assertTrue(one != two);
	}

	@Test
	public void testPartialConstructor2() {
		User one = new User("un1", "pw1".hashCode(), "dn1");
		assertTrue(one instanceof User);
		User two = new User("un2", "pw2".hashCode(), "dn2");
		assertTrue(one != two);
	}

	@Test
	public void testFullConstructor() {
		User one = new User(1, "un1", "pw1".hashCode(), "dn1");
		assertTrue(one instanceof User);
		User two = new User(2, "un2", "pw2".hashCode(), "dn2");
		assertTrue(one != two);
	}
	
	@Test
	public void testHashCode() {
		assertTrue(u1.hashCode() != u2.hashCode());
	}

	@Test
	public void testGetUserId() {
		assertTrue(u1.getUserId().equals(1));
	}

	@Test
	public void testSetUserId() {
		u1.setUserId(2);
		assertTrue(u1.getUserId().equals(u2.getUserId()));
		u1.setUserId(1);
		assertFalse(u1.getUserId().equals(u2.getUserId()));
	}

	@Test
	public void testGetUsername() {
		assertTrue(u1.getUsername().equals("un1"));
	}

	@Test
	public void testSetUsername() {
		u1.setUsername("un2");
		assertTrue(u1.getUsername().equals(u2.getUsername()));
		u1.setUsername("un1");
		assertFalse(u1.getUsername().equals(u2.getUsername()));
	}

	@Test
	public void testGetPassword() {
		assertTrue(u1.getPassword().equals("pw1".hashCode()));
	}

	@Test
	public void testSetPassword() {
		u1.setPassword("pw2".hashCode());
		assertTrue(u1.getPassword().equals(u2.getPassword()));
		u1.setPassword("pw1".hashCode());
		assertFalse(u1.getPassword().equals(u2.getPassword()));
	}

	@Test
	public void testGetDisplayName() {
		assertTrue(u1.getDisplayName().equals("dn1"));
	}

	@Test
	public void testSetDisplayName() {
		u1.setDisplayName("dn2");
		assertTrue(u1.getDisplayName().equals(u2.getDisplayName()));
		u1.setDisplayName("dn1");
		assertFalse(u1.getDisplayName().equals(u2.getDisplayName()));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEqualsObject() {
		assertFalse(u1.equals(u2));
		assertFalse(u1.equals(null));
		assertFalse(u1.equals(""));
		assertFalse(u1.equals(new Object()));
		assertFalse(u1.equals(new User()));
		assertTrue(u1.equals(u1));
	}

	@Test
	public void testToString() {
		assertTrue((u1.toString() instanceof String));
	}
}
