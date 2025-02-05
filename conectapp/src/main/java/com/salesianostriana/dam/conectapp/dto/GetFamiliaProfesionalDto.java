package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.FamiliaProfesional;

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
