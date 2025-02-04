package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Curso;
import lombok.Builder;

import java.util.List;

@Builder
public record CursoResponseDto(
        List<Curso>listaCursos
) {
//    public static CursoResponseDto of(List<Curso> listaCursos){
//        return new CursoResponseDto(
//                (long)listaCursos.size(),
//                listaCursos
//        );
//    }
//
//    public List<Curso> to(){
//        return listaCursos;
//    }

    public static CursoResponseDto fromDto(List<Curso> listadoCursosSinProcesar){
        return CursoResponseDto.builder()
                .listaCursos(listadoCursosSinProcesar.stream().map(CursoDto:: of).toList()).build();

    }
}
