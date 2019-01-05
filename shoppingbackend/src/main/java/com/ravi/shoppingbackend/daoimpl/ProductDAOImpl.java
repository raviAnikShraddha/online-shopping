package com.ravi.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ravi.shoppingbackend.dao.ProductDAO;
import com.ravi.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {
		String query = "FROM Product";
		Query rs = sessionFactory.getCurrentSession().createQuery(query, Product.class);
		return rs.getResultList();
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean upadteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String query = "FROM Product WHERE active = :active";
		Query rs = sessionFactory.getCurrentSession().createQuery(query, Product.class);
		rs.setParameter("active", true);
		return rs.getResultList();
	}

	@Override
	public List<Product> listActiveCategoryByID(int category) {
		String query = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		Query rs = sessionFactory.getCurrentSession().createQuery(query, Product.class);
		rs.setParameter("active", true);
		rs.setParameter("categoryId", category);
		return rs.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProductByID(int count) {
		String query = "FROM Product WHERE active = :active ORDER BY id";
		Query rs = sessionFactory.getCurrentSession().createQuery(query, Product.class);
		rs.setParameter("active", true);
		rs.setFirstResult(0);
		rs.setMaxResults(count);
		return rs.getResultList();
	}

}
