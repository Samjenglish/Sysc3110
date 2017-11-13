package main;

public class BuddyInfo {
	private String name, phoneNumber, address;
	private int age;
	
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
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public BuddyInfo() {
		// TODO Auto-generated constructor stub
	}
	public BuddyInfo(BuddyInfo copy) {
		this.name = copy.name;
		this.phoneNumber = copy.phoneNumber;
		this.address = copy.address;
	}
	
	public String Greeting() {
		return "Hello there, " + this.name;
	}
	public boolean isOver18() {
		return (this.age >= 18);
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
		return this.name + " \n" + this.phoneNumber + " \n" + this.address;
		
	}


}
