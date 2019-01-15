package com.ravi.shoppingbackend.dao;

import java.util.List;

import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	// common methods

	public CartLine get(int id);

	public boolean addCartLine(CartLine cartLine);

	public boolean updateCartLine(CartLine cartLine);

	public boolean deleteCartLine(CartLine cartLine);

	public List<CartLine> list(int cartId);

	// other business method for cartlines

	public List<CartLine> listAvailable(int cartId);

	public CartLine getByCartAndProductId(int cartId, int productId);
	
	// update cart
	boolean updateCart(Cart cart);

}
