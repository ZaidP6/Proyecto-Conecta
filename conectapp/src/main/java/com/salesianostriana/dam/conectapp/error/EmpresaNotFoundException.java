package com.salesianostriana.dam.conectapp.error;

public class EmpresaNotFoundException extends RuntimeException{

    public EmpresaNotFoundException(Long id){
        super("No se ha encontrado ninguna empresa con ID: "+id);
    }

    public EmpresaNotFoundException(String msg){
        super(msg);
    }

}
