package com.ravi.onlineshoppingfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ravi.onlineshoppingfrontend.utility.FileUploadUtil;
import com.ravi.onlineshoppingfrontend.validator.ProductValidator;
import com.ravi.shoppingbackend.dao.CategoryDAO;
import com.ravi.shoppingbackend.dao.ProductDAO;
import com.ravi.shoppingbackend.dto.Category;
import com.ravi.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/manage")
public class ManagementController {

	private static Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product npProduct = new Product();
		npProduct.setSupplierId(3);
		npProduct.setActive(true);
		mv.addObject("product", npProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product submitted successfully !");
			}
		}

		return mv;
	}

	@RequestMapping(value = "{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product npProduct = productDAO.get(id);
		mv.addObject("product", npProduct);

		return mv;
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();
	}

	/***
	 * handling product submission
	 */

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handlePRoductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			if (!(mProduct.getFile() == null || mProduct.getFile().getOriginalFilename().equals(""))) {
				new ProductValidator().validate(mProduct, results);
			}

		}

		logger.info(mProduct.toString());
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("msg", "Validation failed for Product submission !");
			return "page";
		}

		if (mProduct.getId() == 0) {
			// add new product
			productDAO.addProduct(mProduct);
		} else {
			// update product
			productDAO.upadteProduct(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {

			FileUploadUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";

	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {

		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!product.isActive());
		productDAO.upadteProduct(product);
		return isActive ? "You have successfully deactivate the product with id " + product.getId() + " !"
				: "You have successfully activate the product with id " + product.getId() + " !";
	}
}
