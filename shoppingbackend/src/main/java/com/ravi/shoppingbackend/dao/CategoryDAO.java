package com.ravi.shoppingbackend.dao;

import java.util.List;

import com.ravi.shoppingbackend.dto.Category;

public interface CategoryDAO {
	public Category get(int id);

	public List<Category> list();

	boolean addCategory(Category category);

	boolean upadteCategory(Category category);

	boolean deleteCategory(Category category);
}
