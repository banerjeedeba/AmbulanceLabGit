package com.cloth.entities;

public class Client {
	
	private String firstName;
	private String lastName;
	private long count;
	private String blobkey;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getBlobkey() {
		return blobkey;
	}
	public void setBlobkey(String blobkey) {
		this.blobkey = blobkey;
	}
	public Client(String firstName, String lastName, long count, String blobkey) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.count = count;
		this.blobkey = blobkey;
	}

	
}
