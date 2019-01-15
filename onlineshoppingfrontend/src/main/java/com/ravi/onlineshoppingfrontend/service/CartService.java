package com.ravi.onlineshoppingfrontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.onlineshoppingfrontend.model.UserModel;
import com.ravi.shoppingbackend.dao.CartLineDAO;
import com.ravi.shoppingbackend.dao.ProductDAO;
import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.CartLine;
import com.ravi.shoppingbackend.dto.Product;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductDAO productDAO;

	// return the cart of the user who has logged in
	private Cart getCart() {

		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	// returns the entire cart line
	public List<CartLine> getCartLines() {

		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String manageCartLine(int catLineId, int count) {

		CartLine cartLine = cartLineDAO.get(catLineId);

		if (cartLine == null) {

			return "result=error";
		} else {

			Product product = cartLine.getProduct();
			double oldtotal = cartLine.getTotal();

			if (product.getQuantity() < count) {
				return "result=unavailable";
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.updateCartLine(cartLine);
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldtotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			return "result=updated";
		}

	}

	public String deleteCartLine(int cartLineId) {
		CartLine cartLine = cartLineDAO.get(cartLineId);
		if (cartLine == null) {
			return "result=error";
		} else {
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			cartLineDAO.deleteCartLine(cartLine);
			return "result=deleted";
		}
	}

	public String addCartLineProduct(int productId) {

		String response = null;
		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndProductId(cart.getId(), productId);
		if (cartLine == null) {
			cartLine = new CartLine();

			Product product = productDAO.get(productId);
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvaible(true);
			cartLineDAO.addCartLine(cartLine);

			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			response = "result=added";
		} else {

			// check if the cartline reaches it's maximum count
			if (cartLine.getProductCount() < 3) {
				// update the product count for th cartline
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
			} else {
				response = "result=maximum";
			}
		}

		return response;
	}
}
