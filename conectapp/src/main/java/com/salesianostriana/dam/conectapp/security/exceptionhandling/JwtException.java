package com.salesianostriana.dam.conectapp.security.exceptionhandling;

public class JwtException extends RuntimeException{

    public JwtException(String message) {
        super(message);
    }
}
