package com.ravi.shoppingbackend.dao;

import java.util.List;
import com.ravi.shoppingbackend.dto.Product;

public interface ProductDAO {
	public Product get(int id);

	public List<Product> list();

	boolean addProduct(Product product);

	boolean upadteProduct(Product product);

	boolean deleteProduct(Product product);

	// business methods

	List<Product> listActiveProducts();

	List<Product> listActiveCategoryByID(int category);

	List<Product> getLatestActiveProductByID(int count);
}
