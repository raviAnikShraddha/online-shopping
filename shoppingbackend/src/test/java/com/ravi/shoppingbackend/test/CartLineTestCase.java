package com.ravi.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ravi.shoppingbackend.dao.CartLineDAO;
import com.ravi.shoppingbackend.dao.ProductDAO;
import com.ravi.shoppingbackend.dao.UserDAO;
import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.CartLine;
import com.ravi.shoppingbackend.dto.Product;
import com.ravi.shoppingbackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static CartLineDAO cartLineDAO;
	private static UserDAO userDAO;

	private Product product;
	private User user;
	private CartLine cartLine;
	private Cart cart;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.ravi.shoppingbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void addCartLine() {

		// fetch the user
		user = userDAO.getByEmail("anik@gmail.com");

		// fetch cart with respect to the user
		cart = user.getCart();

		// fetch the product by it's id
		product = productDAO.get(2);

		// create cartline

		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvaible(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);

		assertEquals("Falied to insert the cartline", true, cartLineDAO.addCartLine(cartLine));

		// update the cart

		/*cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);

		assertEquals("Falied to insert the cart", true, cartLineDAO.updateCart(cart));*/

	}
}
