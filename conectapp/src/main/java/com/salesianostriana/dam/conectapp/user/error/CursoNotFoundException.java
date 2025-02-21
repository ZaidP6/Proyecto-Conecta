package com.salesianostriana.dam.conectapp.user.error;

public class CursoNotFoundException extends RuntimeException {

  public CursoNotFoundException(Long id){
    super("No se ha encontrado ningún curso con ID: "+id);
  }

  public CursoNotFoundException(String msg){
    super(msg);
  }
}
