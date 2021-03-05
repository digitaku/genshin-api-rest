package com.atilas.genshin.exception;

public class CharactersNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 7126470311039567269L;

    public CharactersNotFoundException(String message) {
        super(message);
    }

}
