package com.ankur.superhero.businesslogic.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ComicWebException extends RuntimeException {

    private HttpStatus status;

    private String message;

    public ComicWebException(String message) {
	super(message);
	this.status = HttpStatus.BAD_REQUEST;
	this.message = message;
    }

}
