package com.salesianostriana.dam.conectapp.user.dto;

import com.salesianostriana.dam.conectapp.user.model.Curso;

public record CursoDto(
        String nombre,
        int horasEmpresa
) {
    public Curso toCurso() {
        return Curso.builder()
                .nombre(nombre)
                .horasEmpresa(horasEmpresa)
                .build();
    }

    public static CursoDto of(Curso curso) {
        return new CursoDto(curso.getNombre(), curso.getHorasEmpresa());
    }
}
