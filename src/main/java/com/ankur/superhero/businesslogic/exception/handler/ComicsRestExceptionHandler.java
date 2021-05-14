package com.ankur.superhero.businesslogic.exception.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ankur.superhero.businesslogic.exception.ComicWebException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import lombok.Data;

@ControllerAdvice("com.ankur.superhero.businesslogic.controller.rest")
public class ComicsRestExceptionHandler {
	
	@ExceptionHandler(ComicWebException.class)
	public ResponseEntity<Error> handleException(ComicWebException ex) {
		
	    return exceptionResponse(ex.getStatus(), ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Error> handleException(MethodArgumentNotValidException ex) {
		
		FieldError fieldError = ex.getBindingResult().getFieldError();
		String validationErrorMessage = "Validation failed on " 
						+ fieldError.getField() + ", " + fieldError.getDefaultMessage();
		return exceptionResponse(HttpStatus.BAD_REQUEST, validationErrorMessage);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<Error> handleException(InvalidFormatException ex) {
		
		return exceptionResponse(HttpStatus.BAD_REQUEST, "Invalid data in category/publisher");
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Error> handleException(MethodArgumentTypeMismatchException ex) {
		
		return exceptionResponse(HttpStatus.BAD_REQUEST, "Invalid data in parameter");
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public  ResponseEntity<Error> handleException(AccessDeniedException ex) {
		
		return exceptionResponse(HttpStatus.FORBIDDEN, ex.getMessage());
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public  ResponseEntity<Error> handleException(AuthenticationException ex) {
		
		return exceptionResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<Error> handleException(Exception ex) {
		
		return exceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
	
	private ResponseEntity<Error> exceptionResponse(HttpStatus status, String message) {
		
		Error error = new Error();
		error.setStatus(status);
		error.setMessage(message);
		error.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a").format(new Date()));
		return new ResponseEntity<Error>(error, status);
	}
}

@Data
class Error {
	
	private HttpStatus status;
	private String message;
	
	@JsonProperty("datetime")
	private String dateTime;
}