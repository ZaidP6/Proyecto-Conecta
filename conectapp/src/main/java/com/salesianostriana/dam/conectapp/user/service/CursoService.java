package com.salesianostriana.dam.conectapp.user.service;

import com.salesianostriana.dam.conectapp.user.dto.CursoDto;
import com.salesianostriana.dam.conectapp.user.dto.CursoGetListaDto;
import com.salesianostriana.dam.conectapp.user.error.CursoNotFoundException;
import com.salesianostriana.dam.conectapp.user.model.Curso;
import com.salesianostriana.dam.conectapp.user.repository.CursoRespository;
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
        return this.cursoRepository.findById(id).orElseThrow(() -> new CursoNotFoundException("Curso con ID: "+id+ " no encontrado."));
    }

    //BUSCAR TODOS LOS CURSOS
    public List<CursoGetListaDto> findAll(){
        List<Curso> listaCursos = cursoRepository.findAll();
        if (listaCursos.isEmpty()) {
            throw new CursoNotFoundException("Lista vacía");
        }
        return listaCursos.stream()
                .map(CursoGetListaDto::of)
                .collect(Collectors.toList());
    }

    //ELIMINAR POR ID
    public void deleteById(Long id){
        cursoRepository.deleteById(id);
    }

    //EDITAR CURSODTO
    public CursoDto edit(Long id, CursoDto cursoDto){
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new CursoNotFoundException("No se ha encontrado ningun curso con id: " +id));
            curso.setNombre(cursoDto.nombre());
            curso.setHorasEmpresa(cursoDto.horasEmpresa());

        cursoRepository.save(curso);
        return CursoDto.of(curso);
    }
    

}
