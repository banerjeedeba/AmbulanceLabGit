package com.style.web.response;

import java.io.Serializable;

public class Profile implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1126878878787L;
	private int profileid;
	private String firstname;
	private String lastname;
	private String address;
	private String contactNo;
	private String ccNumber;
	private String email;
	private String blobKey;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public Profile()
	{
		
	}
	

	public Profile(int profileid, String firstname, String lastname, String address, String contactNo, String ccNumber,
			String email, String blobKey) {
		super();
		this.profileid = profileid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.contactNo = contactNo;
		this.ccNumber = ccNumber;
		this.email = email;
		this.blobKey = blobKey;
	}

	public String getBlobKey() {
		return blobKey;
	}

	public void setBlobKey(String blobKey) {
		this.blobKey = blobKey;
	}
	
	

}
