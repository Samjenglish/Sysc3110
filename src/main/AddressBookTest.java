package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private AddressBook addressBook;
	private BuddyInfo buddy;
	
	@Before
	public void setUp() {
		addressBook = new AddressBook();
		buddy = new BuddyInfo("Sam", "123456789", "Ottawa");
	}

	@Test
	public void testEmptyAddressBook() {
		assertEquals(addressBook.size(), 0);
	}
	@Test
	public void testOneEntryAddressBook() {
		addressBook.addBuddy(buddy);
		assertEquals(addressBook.size(), 1);
	}
	@Test
	public void testContainsAddressBook() {
		addressBook.addBuddy(buddy);
		assertEquals(buddy.equals(addressBook.seeBuddy(0)), true);
	}
	@Test
	public void testClearAddressBook() {
		addressBook.addBuddy(buddy);
		addressBook.clear();
		assertEquals(addressBook.size(), 0);
	}
	@Test
	public void testRemoveAddressBook() {
		addressBook.addBuddy(buddy);
		addressBook.removeBuddy(0);
		assertEquals(addressBook.size(), 0);
	}
	@Test
	public void testAddAddressBook() {
		addressBook.addBuddy(buddy);
		assertEquals(addressBook.size(), 1);
	}

}
