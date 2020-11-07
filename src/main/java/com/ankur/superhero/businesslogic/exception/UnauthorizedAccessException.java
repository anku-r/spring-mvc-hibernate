package com.ankur.superhero.businesslogic.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class UnauthorizedAccessException extends ComicWebException {

	public UnauthorizedAccessException() {
		super(HttpStatus.FORBIDDEN, "Request is Unauthorized");
	}
	
	public UnauthorizedAccessException(String message) {
		super(HttpStatus.FORBIDDEN, message);
	}
}
