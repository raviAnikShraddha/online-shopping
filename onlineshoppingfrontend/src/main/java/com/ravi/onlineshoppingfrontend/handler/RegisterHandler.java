package com.ravi.onlineshoppingfrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ravi.onlineshoppingfrontend.model.RegisterModel;
import com.ravi.shoppingbackend.dao.UserDAO;
import com.ravi.shoppingbackend.dto.Address;
import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;

	public RegisterModel init() {

		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {

		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {

		registerModel.setBilling(billing);
	}

	public String saveAll(RegisterModel registerModel) {

		String transitionValue = "success";
		User user = registerModel.getUser();

		if (user.getRole().equals("USER")) {

			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);

		}
		userDAO.addUser(user);

		// save billing

		Address billing = registerModel.getBilling();
		billing.setUser(user);
		billing.setBilling(true);

		userDAO.addAddress(billing);

		return transitionValue;
	}

}
