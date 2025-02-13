package com.salesianostriana.dam.conectapp.user.dto;

import com.salesianostriana.dam.conectapp.user.model.Curso;
import lombok.Builder;

@Builder
public record CursoGetListaDto(
        Long id,
        String nombre,
        int horasEmpresa
) {
    public static CursoGetListaDto of(Curso curso){
        return new CursoGetListaDto(
                curso.getId(),
                curso.getNombre(),
                curso.getHorasEmpresa()
        );
    }
}
