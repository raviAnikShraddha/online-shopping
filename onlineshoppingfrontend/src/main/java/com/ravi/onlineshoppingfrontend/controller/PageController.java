package com.ravi.onlineshoppingfrontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ravi.onlineshoppingfrontend.exception.ProductNotFoundException;
import com.ravi.shoppingbackend.dao.CategoryDAO;
import com.ravi.shoppingbackend.dao.ProductDAO;
import com.ravi.shoppingbackend.dto.Category;
import com.ravi.shoppingbackend.dto.Product;

@Controller
public class PageController {

	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		logger.info("Inside the PageController >>>>> INFO");
		logger.debug("Inside the PageController >>>>> DEBUG");
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
			System.out.println("name -- " + name);
		} else {
			mv.addObject("title", category.getName());
			System.out.println("category.getName() -- " + category.getName());
		}
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		return mv;
	}

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {

		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);

		if (product == null)
			throw new ProductNotFoundException();

		product.setViews(product.getViews() + 1);
		productDAO.upadteProduct(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);

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

	@RequestMapping(value = "/register")
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		return mv;
	}

	/*** ---- login ---- ****/

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		ModelAndView mv = new ModelAndView("login");
		if (error != null) {
			mv.addObject("message", "Invalid UserName and Password !");
		}
		if (logout != null) {
			mv.addObject("logout", "User is successfully logged out !");
		}
		mv.addObject("title", "Login");
		return mv;
	}

	/*** ---- logout ---- ****/

	@RequestMapping(value = "/perform-login")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login?lgout";
	}

	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "UnAuthorised User !");
		mv.addObject("errorDescription", "You are not authorised to access this page !");
		return mv;
	}

}
