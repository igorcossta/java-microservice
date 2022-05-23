package com.igorcossta.common.exception;

public class AuthorHasNoBookException extends ApiException {

    public AuthorHasNoBookException() {
        super("Requested entity has no book");
    }

    public AuthorHasNoBookException(String message) {
        super(message);
    }
}
