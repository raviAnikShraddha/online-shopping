package com.ravi.onlineshoppingfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("message", "Welcome to spring web MVC !");
		return mv;
		
	}
	
/*	@RequestMapping(value = {"/test"})
	public ModelAndView test(@RequestParam("greeting")String msg) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("message", msg);
		return mv;
		
	}*/
	
	/*@RequestMapping(value = {"/test/{greeting}"})
	public ModelAndView test(@PathVariable("greeting")String msg) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("message", msg);
		return mv;
		
	}*/

}
