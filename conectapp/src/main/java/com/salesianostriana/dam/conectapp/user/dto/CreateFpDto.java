package com.salesianostriana.dam.conectapp.user.dto;

import com.salesianostriana.dam.conectapp.user.model.FamiliaProfesional;

public record CreateFpDto(
        String nombre
) {

    public FamiliaProfesional toFp(){
        return FamiliaProfesional.builder()
                .nombre(nombre)
                .build();
    }

}
