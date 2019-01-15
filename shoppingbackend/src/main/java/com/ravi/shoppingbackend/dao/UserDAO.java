package com.ravi.shoppingbackend.dao;

import java.util.List;

import com.ravi.shoppingbackend.dto.Address;
import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.User;

public interface UserDAO {

	// add user
	boolean addUser(User user);
	
	User getByEmail(String email);

	// add address
	boolean addAddress(Address address);
	
	Address getShippingAddressByUser(User user);
	List<Address> getShippingAddress(User user);;


}
