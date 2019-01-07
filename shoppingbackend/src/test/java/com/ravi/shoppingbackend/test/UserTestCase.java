package com.ravi.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ravi.shoppingbackend.dao.UserDAO;
import com.ravi.shoppingbackend.dto.Address;
import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;
	private Address address;
	private Cart cart;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.ravi.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*
	 * @Test public void testSelectCategory() {
	 * 
	 * // add user user = new User(); user.setFirstName("Anik Pratap");
	 * user.setLastName("Kashyap"); user.setEmail("anikpratapkashyap");
	 * user.setContactNumber("9984117819"); user.setPassword("123456");
	 * user.setRole("USER");
	 * 
	 * assertEquals("Succesfully added user inside the table !", true,
	 * userDAO.addUser(user));
	 * 
	 * // add address
	 * 
	 * address = new Address(); address.setAddressLineOne("Tateri bazar");
	 * address.setAddressLineTwo("Siddhartha nagar"); address.setBilling(true);
	 * address.setShipping(true); address.setState("Uttar Pradesh");
	 * address.setCity("Lucknow"); address.setPostalCode("272207");
	 * address.setUserId(user.getId()); address.setCountry("India");
	 * 
	 * assertEquals("Succesfully added address inside the table !", true,
	 * userDAO.addAddress(address));
	 * 
	 * // add cart
	 * 
	 * if (user.getRole().equals("USER")) {
	 * 
	 * cart = new Cart(); cart.setUser(user);
	 * 
	 * assertEquals("Succesfully added cart inside the table !", true,
	 * userDAO.addCart(cart)); } }
	 */

	/*
	 * @Test public void testSelectCategory() {
	 * 
	 * // add user user = new User(); user.setFirstName("Anik Pratap");
	 * user.setLastName("Kashyap"); user.setEmail("anikpratapkashyap");
	 * user.setContactNumber("9984117819"); user.setPassword("123456");
	 * user.setRole("USER");
	 * 
	 * if (user.getRole().equals("USER")) {
	 * 
	 * cart = new Cart(); cart.setUser(user); user.setCart(cart); }
	 * assertEquals("Succesfully added user inside the table !", true,
	 * userDAO.addUser(user)); }
	 */

	/*
	 * @Test public void updateCart() {
	 * 
	 * // fetch the user by email user = userDAO.getByEmail("anikpratapkashyap");
	 * 
	 * // update the cart respect to the particular user cart = user.getCart();
	 * cart.setGrandTotal(1500.23); cart.setCartLines(2);
	 * 
	 * assertEquals("Succesfully added user inside the table !", true,
	 * userDAO.updateCart(cart)); }
	 */

	/*
	 * @Test public void testUserAddress() {
	 * 
	 * // add new User
	 * 
	 * user = new User(); user.setFirstName("Ravi Pratap");
	 * user.setLastName("Kashyap"); user.setEmail("ravikpratapkashyap@gmail.com");
	 * user.setContactNumber("9889046425"); user.setPassword("123456");
	 * user.setRole("USER");
	 * 
	 * assertEquals("Succesfully added user inside the table !", true,
	 * userDAO.addUser(user));
	 * 
	 * // add Address
	 * 
	 * address = new Address(); address.setAddressLineOne("Tateri bazar");
	 * address.setAddressLineTwo("Siddhartha nagar"); address.setBilling(true); //
	 * address.setShipping(true); address.setState("Uttar Pradesh");
	 * address.setCity("Lucknow"); address.setPostalCode("272207");
	 * address.setCountry("India");
	 * 
	 * address.setUser(user);
	 * 
	 * assertEquals("Succesfully added address inside the table !", true,
	 * userDAO.addAddress(address));
	 * 
	 * address = new Address(); address.setAddressLineOne("Tateri bazar");
	 * address.setAddressLineTwo("Siddhartha nagar"); // address.setBilling(true);
	 * address.setShipping(true); address.setState("Uttar Pradesh");
	 * address.setCity("Lucknow"); address.setPostalCode("272207");
	 * address.setCountry("India");
	 * 
	 * address.setUser(user);
	 * 
	 * assertEquals("Succesfully added address inside the table !", true,
	 * userDAO.addAddress(address));
	 * 
	 * }
	 */

	@Test
	public void testAddintionOfAddress() {

		user = userDAO.getByEmail("ravikpratapkashyap@gmail.com");
		assertEquals("get the user List Address !", 2, userDAO.getShippingAddress(user).size());
		assertEquals("get the user Address !", "Africa", userDAO.getShippingAddressByUser(user).getCountry());

	}

}
