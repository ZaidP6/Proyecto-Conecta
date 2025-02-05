package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.FamiliaProfesional;

public record CreateFpDto(
        String nombre
) {

    public FamiliaProfesional toFp(){
        return FamiliaProfesional.builder()
                .nombre(nombre)
                .build();
    }

}
