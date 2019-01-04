package com.ravi.onlineshoppingfrontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDeafultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "This is page is not constructed !");
		mv.addObject("errorDescription", "The page you are looking for is not available !");
		mv.addObject("title", "404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The product is not available !");
		mv.addObject("errorDescription", "The product you are looking for is not available right now !");
		mv.addObject("title", "Product unavailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorTitle", "Error !");
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title", "error");
		return mv;
	}

}
