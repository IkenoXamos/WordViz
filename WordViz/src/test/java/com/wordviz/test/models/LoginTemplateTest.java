package com.wordviz.test.models;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.wordviz.user.LoginTemplate;

import nl.jqno.equalsverifier.EqualsVerifier;

public class LoginTemplateTest {
	private LoginTemplate lt1;
	
	@Before
	public void setup() {
		lt1 = new LoginTemplate("Name1", 12345);
	}

	@Test
	public void testLoginTemplate() {
		LoginTemplate one = new LoginTemplate();
		assertTrue(one instanceof LoginTemplate);
		LoginTemplate two = new LoginTemplate();
		assertTrue(one != two);
	}

	@Test
	public void testLoginTemplateStringInteger() {
		LoginTemplate one = new LoginTemplate("RName1", 255);
		assertTrue(one instanceof LoginTemplate);
		LoginTemplate two = new LoginTemplate("RName2", 2544);
		assertTrue(one != two);
	}

	@Test
	public void testGetUsername() {
		assertTrue(lt1.getUsername().equals("Name1"));
	}

	@Test
	public void testSetUsername() {
		lt1.setUsername("RandomUser");
		assertTrue(lt1.getUsername().equals("RandomUser"));
	}

	@Test
	public void testGetPassword() {
		assertTrue(lt1.getPassword().equals(12345));
	}

	@Test
	public void testSetPassword() {
		lt1.setPassword(5555);
		assertTrue(lt1.getPassword().equals(5555));
	}

	@Test
	public void testEqualsObject() {
		EqualsVerifier.forClass(LoginTemplate.class).verify();
	}

	@Test
	public void testToString() {
		assertTrue((lt1.toString() instanceof String));
	}
}
