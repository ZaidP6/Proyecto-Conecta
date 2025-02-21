package com.salesianostriana.dam.conectapp.user.error;

public class FamiliaProfesionalNotFoundException extends RuntimeException {

    public FamiliaProfesionalNotFoundException(Long id) {
        super("No se ha encontrado ninguna empresa con ID: "+id);
    }

    public FamiliaProfesionalNotFoundException(String msg){
    super(msg);
  }
}
