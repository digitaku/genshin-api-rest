package com.atilas.genshin.exception;

public class UserAlreadyExistException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 3435541382385733369L;

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
