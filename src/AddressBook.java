import java.util.Map;

public class AddressBook {
	private Map<String, BuddyInfo> Book;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressBook Book1 = new AddressBook();
		BuddyInfo buddy1 = new BuddyInfo("Sam");
		BuddyInfo buddy2 = new BuddyInfo("Austin");
		BuddyInfo buddy3 = new BuddyInfo("Nikola");
		Book1.addBuddy(buddy1);
		Book1.addBuddy(buddy2);
		Book1.addBuddy(buddy3);
	}
	
	public void addBuddy(BuddyInfo newBuddy) {
			Book.put(newBuddy.getName(), newBuddy);
	}
	public void removeBuddy(BuddyInfo oldBuddy) {
			Book.remove(oldBuddy.getName(), oldBuddy);
	}

}
