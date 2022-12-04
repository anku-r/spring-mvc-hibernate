package com.ankur.superhero.businesslogic.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class CharacterNameAlreadyPresentException extends ComicWebException {

    public CharacterNameAlreadyPresentException(String message) {
	super(HttpStatus.CONFLICT, message);
    }

    public CharacterNameAlreadyPresentException() {
	super(HttpStatus.CONFLICT, "Character with provided name already present");
    }
}
