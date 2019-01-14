package com.ravi.onlineshoppingfrontend.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

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

		// encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userDAO.addUser(user);

		// save billing

		Address billing = registerModel.getBilling();
		billing.setUser(user);
		billing.setBilling(true);

		userDAO.addAddress(billing);

		return transitionValue;
	}

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public String validateUser(User user, MessageContext error) {

		String transition = "success";

		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password does not matches with confirm password !").build());

			transition = "failure";
		}

		if (userDAO.getByEmail(user.getEmail()) != null) {
			error.addMessage(
					new MessageBuilder().error().source("email").defaultText("This email is already exist !").build());
			transition = "failure";
		}

		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(user.getEmail());

		if (!matcher.matches()) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Invalid Email Id !").build());
			transition = "failure";
		}

		return transition;
	}

}
