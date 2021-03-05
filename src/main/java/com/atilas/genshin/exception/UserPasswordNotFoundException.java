package com.atilas.genshin.exception;

public class UserPasswordNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 2454542092768038313L;

    public UserPasswordNotFoundException(String message) {
        super(message);
    }
}
