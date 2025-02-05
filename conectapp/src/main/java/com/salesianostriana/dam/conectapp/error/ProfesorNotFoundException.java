package com.salesianostriana.dam.conectapp.error;

public class ProfesorNotFoundException extends RuntimeException {
  public ProfesorNotFoundException(Long id){
    super("No se ha encontrado ningún usuario con ID: "+id);
  }

  public ProfesorNotFoundException(String msg){
    super(msg);
  }
}
