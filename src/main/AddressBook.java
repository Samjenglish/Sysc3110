package main;

import java.util.ArrayList;
import java.util.List;


public class AddressBook{

	private List<BuddyInfo> bookList;
	public void main(String[] args) {
		// TODO Auto-generated method stub
	}

	
	public AddressBook() {
		bookList = new ArrayList<BuddyInfo>();
	}
	public void addBuddy(BuddyInfo newBuddy) {
		if(newBuddy != null) {
			this.getBookList().add(newBuddy);
		}

	}
	public BuddyInfo seeBuddy(int index) {
		if(index >= 0 && index < this.getBookList().size()) {
			return this.getBookList().get(index);
		}
		return null;
	}
	public BuddyInfo removeBuddy(int index) {
		if(index >= 0 && index < this.getBookList().size()) {
			return this.getBookList().remove(index);
		}
		return null;
	}
	public List<BuddyInfo> getBookList() {
		return bookList;
	}
	public int size() {
		return bookList.size();
	}
	public void clear() {
	  bookList.clear();
	}
}


