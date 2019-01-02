package com.ravi.shoppingbackend.dao;

import java.util.List;

import com.ravi.shoppingbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> list();

	public Category get(int id);

}
