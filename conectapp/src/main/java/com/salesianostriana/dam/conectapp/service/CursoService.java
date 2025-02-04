package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CursoDto;
import com.salesianostriana.dam.conectapp.dto.CursoGetListaDto;
import com.salesianostriana.dam.conectapp.model.Curso;
import com.salesianostriana.dam.conectapp.repository.CursoRespository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    //BUSCAR POR ID
    public Curso findById(Long id){
        return this.cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso con ID: "+id+ " no encontrado."));
    }

    //BUSCAR TODOS LOS CURSOS
    public List<CursoGetListaDto> findAll(){
        List<Curso> listaCursos = cursoRepository.findAll();
        if (listaCursos.isEmpty()) {
            throw new EntityNotFoundException("Lista vacía");
        }
        return listaCursos.stream()
                .map(CursoGetListaDto::of)
                .collect(Collectors.toList());
    }

}
