package com.ravi.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ravi.shoppingbackend.dao.CategoryDAO;
import com.ravi.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.ravi.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Laptop");
	 * category.setDescription("This is the description of Laptop !");
	 * category.setActive(true); category.setImageUrl("television.png");
	 * assertEquals("Succesfully added category inside the table !", true,
	 * categoryDAO.addCategory(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testSelectCategory() {
	 * 
	 * category = categoryDAO.get(2); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(2); category.setName("Lappy");
	 * assertEquals("Succesfully added category inside the table !", true,
	 * categoryDAO.upadteCategory(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(2);
	 * assertEquals("Succesfully added category inside the table !", true,
	 * categoryDAO.deleteCategory(category)); }
	 */

	@Test
	public void testSelectCategory() {

		assertEquals("Succesfully added category inside the table !", 1, categoryDAO.list().size());
	}

}
