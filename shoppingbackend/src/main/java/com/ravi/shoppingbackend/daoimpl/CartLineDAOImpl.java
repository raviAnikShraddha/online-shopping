package com.ravi.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ravi.shoppingbackend.dao.CartLineDAO;
import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CartLine get(int id) {
		return sessionFactory.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean addCartLine(CartLine cartLine) {

		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateCartLine(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartLine(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CartLine> list(int cartId) {
		return sessionFactory.getCurrentSession().createQuery("FROM CartLine WHERE cartId = :cartId", CartLine.class)
				.setParameter("cartId", cartId).getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM CartLine WHERE cartId = :cartId AND available = :available", CartLine.class)
				.setParameter("cartId", cartId).setParameter("available", true).getResultList();
	}

	@Override
	public CartLine getByCartAndProductId(int cartId, int productId) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("FROM CartLine WHERE cartId = :cartId AND product.id = :productId", CartLine.class)
					.setParameter("cartId", cartId).setParameter("productId", productId).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
