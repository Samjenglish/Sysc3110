package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	private BuddyInfo buddy;
	
	@Before
	public void setUp(){
		buddy = new BuddyInfo();
	}

	@Test
	public void testAgeUnder() {
		buddy.setAge(17);
		assertEquals(buddy.isOver18(), false);
	}
	@Test
	public void testAgeOver() {
		buddy.setAge(20);
		assertEquals(buddy.isOver18(), true);
	}
	
	@Test
	public void testCopyConstructor() {
		buddy.setName("Sam");
		buddy.setAddress("Main Street, Ottawa");
		buddy.setPhoneNumber("7371111");
		BuddyInfo buddy2 = new BuddyInfo(buddy);
		assertTrue(buddy.getName().equals(buddy2.getName()) || buddy.getPhoneNumber().equals(buddy2.getPhoneNumber()) || buddy.getAddress().equals(buddy2.getAddress()));
	}
	@Test
	public void testAge() {
		buddy.setAge(18);
		assertEquals(buddy.getAge(), 18);
	}
	@Test
	public void testName() {
		buddy.setName("Sam");
		assertEquals(buddy.getName(), "Sam");
	}
	@Test
	public void testPhoneNumber() {
		buddy.setPhoneNumber("123");
		assertEquals(buddy.getPhoneNumber(), "123");
	}
	@Test
	public void testAddress() {
		buddy.setAddress("Ontario, Canada");
		assertEquals(buddy.getAddress(), "Ontario, Canada");
	}
	
	@Test
	public void testGreeting() {
		buddy.setName("Sammy");
		assertEquals(buddy.Greeting(), "Hello there, Sammy");
	}
	
	
	

}
