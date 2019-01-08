package com.ravi.onlineshoppingfrontend.model;

import java.io.Serializable;

import com.ravi.shoppingbackend.dto.Address;
import com.ravi.shoppingbackend.dto.User;

public class RegisterModel implements Serializable{

	/*
	 * private fields
	 * */

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Address billing;
	/*
	 * setter and getter
	 * */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	
	
	
	
}
