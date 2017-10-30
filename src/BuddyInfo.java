
public class BuddyInfo {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String address;
	private String phoneNumber;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		BuddyInfo buddy = new BuddyInfo("Homer");
	}
	public BuddyInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public BuddyInfo(String name) {
		this.setName(name);
	}
	public BuddyInfo(String name, String number) {
		this(name);
		this.setPhoneNumber(number);
	}
	public BuddyInfo(String inpName, String inpNumber, String inpAddress) {
		this(inpName, inpNumber);
		this.setAddress(inpAddress);
	}
	public String toString() {
		return this.name + "\n" + this.phoneNumber + "\n" + this.address;
		
	}

}
