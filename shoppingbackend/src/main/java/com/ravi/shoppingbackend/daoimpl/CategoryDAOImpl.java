package com.ravi.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.ravi.shoppingbackend.dao.CategoryDAO;
import com.ravi.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is the description of television !");
		category.setActive(true);
		category.setImageUrl("television.png");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is the description of Mobile !");
		category.setActive(true);
		category.setImageUrl("mobile.png");
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is the description of Laptop !");
		category.setActive(true);
		category.setImageUrl("mobile.png");
		categories.add(category);

	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category : categories) {
			if(category.getId() == id)return category;
		}
		return null;
	}

}
