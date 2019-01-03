package com.ravi.onlineshoppingfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ravi.shoppingbackend.dao.CategoryDAO;
import com.ravi.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Show All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		String name = category.getName().replace(' ', '-');
		if (category.getName().indexOf(' ') >= 0) {
			mv.addObject("title", name);
			System.out.println("name -- "+name);
		} else {
			mv.addObject("title", category.getName());
			System.out.println("category.getName() -- "+category.getName());
		}
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		return mv;
	}

	/*
	 * @RequestMapping(value = {"/test"}) public ModelAndView
	 * test(@RequestParam("greeting")String msg) {
	 * 
	 * ModelAndView mv = new ModelAndView("page"); mv.addObject("message", msg);
	 * return mv;
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = {"/test/{greeting}"}) public ModelAndView
	 * test(@PathVariable("greeting")String msg) {
	 * 
	 * ModelAndView mv = new ModelAndView("page"); mv.addObject("message", msg);
	 * return mv;
	 * 
	 * }
	 */

}
