package com.ankur.superhero.businesslogic.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class RequestNotFoundException extends ComicWebException {
	
	public RequestNotFoundException() {
		super(HttpStatus.NOT_FOUND, "Not Found");
	}
	
	public RequestNotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
}
