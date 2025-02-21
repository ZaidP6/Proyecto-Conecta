package com.salesianostriana.dam.conectapp.user.dto;

import com.salesianostriana.dam.conectapp.user.model.FamiliaProfesional;

public record GetFamiliaProfesionalDto(
        Long id,
        String nombre
) {

    public static GetFamiliaProfesionalDto of (FamiliaProfesional fp){
        return new GetFamiliaProfesionalDto(
                fp.getId(),
                fp.getNombre()
        );
    }

}
