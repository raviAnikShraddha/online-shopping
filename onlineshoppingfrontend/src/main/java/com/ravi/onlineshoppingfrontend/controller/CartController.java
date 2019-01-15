package com.ravi.onlineshoppingfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ravi.onlineshoppingfrontend.service.CartService;
import com.sun.mail.iap.Response;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {

		ModelAndView mv = new ModelAndView("page");

		if (result != null) {

			switch (result) {
			case "updated":
				mv.addObject("message", "CartLine has been successfully updated !");
				break;
			case "added":
				mv.addObject("message", "CartLine has been successfully added !");
				break;
			case "maximum":
				mv.addObject("message", "CartLine has reached to maximum count !");
				break;
			case "unavailable":
				mv.addObject("message", "Product is not available !");
				break;
			case "deleted":
				mv.addObject("message", "CartLine has been successfully deleted !");
				break;
			case "error":
				mv.addObject("message", "Something went wrong !");
				break;

			}
		}

		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());
		return mv;
	}

	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {

		String response = cartService.manageCartLine(cartLineId, count);
		return "redirect:/cart/show?" + response;
	}

	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {

		String response = cartService.deleteCartLine(cartLineId);

		return "redirect:/cart/show?" + response;
	}

	@RequestMapping("/add/{productId}/product")
	public String addCartLineProduct(@PathVariable int productId) {

		String response = cartService.addCartLineProduct(productId);

		return "redirect:/cart/show?" + response;
	}
}
