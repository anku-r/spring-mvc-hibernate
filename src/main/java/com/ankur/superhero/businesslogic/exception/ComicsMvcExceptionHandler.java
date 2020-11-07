package com.ankur.superhero.businesslogic.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ankur.superhero.app.util.AppConstants;

@ControllerAdvice("com.ankur.superhero.businesslogic.controller.mvc")
public class ComicsMvcExceptionHandler implements AppConstants {

	@ExceptionHandler(ComicWebException.class)
	public String generateExceptionView(ComicWebException ex, Model model) {
		
	    model.addAttribute(ERROR_CODE_ATR, ex.getStatus().value());
		model.addAttribute(ERROR_MESSAGE_ATR, ex.getMessage());
		return ERROR;
	}
	
	@ExceptionHandler(Exception.class)
	public String generateExceptionView(Exception ex, Model model) {
		
	    model.addAttribute(ERROR_CODE_ATR, E_500);
		model.addAttribute(ERROR_MESSAGE_ATR, ex.getMessage());
		return ERROR;
	}
}

