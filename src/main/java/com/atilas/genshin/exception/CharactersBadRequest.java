package com.atilas.genshin.exception;

public class CharactersBadRequest extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -5874595005411678385L;

    public CharactersBadRequest(String message) {
        super(message);
    }
}
