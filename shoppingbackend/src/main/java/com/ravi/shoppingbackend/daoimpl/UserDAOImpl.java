package com.ravi.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ravi.shoppingbackend.dao.UserDAO;
import com.ravi.shoppingbackend.dto.Address;
import com.ravi.shoppingbackend.dto.Cart;
import com.ravi.shoppingbackend.dto.Product;
import com.ravi.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {

		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

	@Override
	public User getByEmail(String email) {
		try {
			String sql = "FROM User WHERE email = :email ";
			return sessionFactory.getCurrentSession().createQuery(sql, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Address getShippingAddressByUser(User user) {
		try {
			String sql = "FROM Address WHERE user = :user AND billing = :billing ";
			return sessionFactory.getCurrentSession().createQuery(sql, Address.class).setParameter("user", user)
					.setParameter("billing", true).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Address> getShippingAddress(User user) {
		try {
			String sql = "FROM Address WHERE user = :user AND shipping = :shipping ";
			return sessionFactory.getCurrentSession().createQuery(sql, Address.class).setParameter("user", user)
					.setParameter("shipping", true).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
