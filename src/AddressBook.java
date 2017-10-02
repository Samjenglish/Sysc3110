import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private List<BuddyInfo> addressBook = new ArrayList<BuddyInfo>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressBook Book1 = new AddressBook();
		BuddyInfo buddy1 = new BuddyInfo("Sam");
		Book1.addBuddy(buddy1);	
		Book1.removeBuddy(0);
	}
	
	public void addBuddy(BuddyInfo newBuddy) {
		if(newBuddy != null) {
			this.addressBook.add(newBuddy);
		}

	}
	public BuddyInfo removeBuddy(int index) {
		if(index >= 0 && index < this.addressBook.size()) {
			return this.addressBook.remove(index);
		}
		return null;
	}

}
