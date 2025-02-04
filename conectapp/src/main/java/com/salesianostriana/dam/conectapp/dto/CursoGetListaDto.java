package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Curso;
import lombok.Builder;

import java.util.List;

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
