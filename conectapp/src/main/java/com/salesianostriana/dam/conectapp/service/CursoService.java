package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CursoDto;
import com.salesianostriana.dam.conectapp.model.Curso;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.repository.CursoRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRespository cursoRepository;

    public Curso addCurso(CursoDto dto) {
        Curso nuevoCurso = Curso.builder()
                .nombre(dto.nombre())
                .horasEmpresa(dto.horasEmpresa())
                .build();

        Curso cursoGuardado = cursoRepository.save(nuevoCurso);
        System.out.println("Curso guardado: " + cursoGuardado);

        return cursoGuardado;
    }

}
