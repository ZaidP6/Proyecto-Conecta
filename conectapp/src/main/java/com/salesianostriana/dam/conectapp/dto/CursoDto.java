package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Curso;

public record CursoDto(
        Long id,
        String nombre,
        int horasEmpresa
) {
//    public static GetCursoDto of(Curso curso) {
//        return new GetCursoDto(
//                curso.getId(),
//                curso.getNombre(),
//                curso.getHorasEmpresa()
//        );
//    }
}
