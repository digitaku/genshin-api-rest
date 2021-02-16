package com.atilas.genshin.exception;

public class CharactersBadRequest extends RuntimeException{
    public CharactersBadRequest(String message) {
        super(message);
    }
}
