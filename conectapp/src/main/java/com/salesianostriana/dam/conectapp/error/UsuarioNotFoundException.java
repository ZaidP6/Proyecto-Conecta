package com.salesianostriana.dam.conectapp.error;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id){
        super("No se ha encontrado ningún usuario con ID: "+id);
    }

    public UsuarioNotFoundException(String msg){
        super(msg);
    }
}
