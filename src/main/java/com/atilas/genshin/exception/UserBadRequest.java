package com.atilas.genshin.exception;

public class UserBadRequest extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -4923060465731153267L;

    public UserBadRequest(String message) {
        super(message);
    }
}
