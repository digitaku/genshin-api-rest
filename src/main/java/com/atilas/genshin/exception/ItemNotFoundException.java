package com.atilas.genshin.exception;

public class ItemNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 5028588224028370215L;

    public ItemNotFoundException(String s) {
        super(s);
    }
}
