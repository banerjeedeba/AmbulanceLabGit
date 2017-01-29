package com.cloth.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class User {

	@Id private String userId;
	private String userPin;
	
	public User() {
		userId = "default";
		userPin = "12345678";
	}
	
	public User(String userId, String userPin){
		this.userId = userId;
		this.userPin = userPin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPin() {
		return userPin;
	}

	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
	
	
}
