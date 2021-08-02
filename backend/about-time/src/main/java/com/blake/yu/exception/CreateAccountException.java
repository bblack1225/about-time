package com.blake.yu.exception;


public class CreateAccountException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CreateAccountException() {
        super();
    }

    public CreateAccountException(String message) {
        super(message);
    }
}
