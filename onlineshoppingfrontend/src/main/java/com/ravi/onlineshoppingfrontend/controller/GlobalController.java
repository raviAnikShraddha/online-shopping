package com.ravi.onlineshoppingfrontend.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ravi.onlineshoppingfrontend.model.UserModel;
import com.ravi.shoppingbackend.dao.UserDAO;
import com.ravi.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {
	
	

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDAO userDAO;

	private UserModel userModel = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {

		if (session.getAttribute("userModel") == null) {

			// add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDAO.getByEmail(authentication.getName());

			if (user != null) {

				// create the new user model to pass the details

				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				userModel.setEmail(user.getEmail());

				if (userModel.getRole().equals("USER")) {

					userModel.setCart(user.getCart());
				}
				// set the user model in session
				session.setAttribute("userModel", userModel);
				return userModel;
			}

		}
		return (UserModel) session.getAttribute("userModel");
	}
}
