
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
	public BuddyInfo(String name) {
		this.name = name;
		System.out.println("Hello, " + name);
	}
	

}
