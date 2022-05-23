package com.igorcossta.common.exception;

public class AuthorNotFoundException extends ApiException {

    public AuthorNotFoundException() {
        super("Requested entity not exists");
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }

}
