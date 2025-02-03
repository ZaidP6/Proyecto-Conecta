package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateProfesorWithUserDto;
import com.salesianostriana.dam.conectapp.dto.ProfesorDto;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.repository.ProfesorRepository;
import com.salesianostriana.dam.conectapp.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;


    //AÑADIR
    public Profesor addNew(Profesor profesor) {
        // Verificar si el nombre de usuario ya existe
        /*
        if (usuarioRepository.existsByUserName(dto.userName())) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }
         */
        return profesorRepository.save(Profesor.builder()
                .nombre(profesor.getNombre())
                .apellidos(profesor.getApellidos())
                .email(profesor.getEmail())
                .telefono(profesor.getTelefono())
                        .build());

    }

    //BUSCAR POR ID
    public Profesor findById(Long id){
        return this.profesorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profesor con ID: "+id+ " no encontrado."));
    }

    //BUSCAR TODOS LOS PROFESORES
    public List<ProfesorDto> findAll(){
        List<Profesor> listaProfes = profesorRepository.findAll();
        if (listaProfes.isEmpty()){
            throw new EntityNotFoundException("Lista vacía");
        }
        return listaProfes.stream().map(ProfesorDto::of).toList();  //buscar mas info para entender bien

    }

    //EDITAR PROFE BUSCANDO POR ID
    public Profesor editById(Profesor p, Long id){
        return profesorRepository.findById(id).map(
                pOld -> {
                    pOld.setNombre(p.getNombre());
                    pOld.setApellidos(p.getApellidos());
                    pOld.setEmail(p.getEmail());
                    pOld.setTelefono(p.getTelefono());

                    if (p.getUsuario() != null && p.getUsuario().getId() != null) {
                        usuarioRepository.findById(p.getUsuario().getId()).ifPresent(pOld::setUsuario);
                    }
                    return  profesorRepository.save(pOld);

                }
        ).orElseThrow(() -> new EntityNotFoundException("Profesor con ID:"+id+" no encontrado"));
    }

    //ELIMINAR PROFE POR ID
    public void deleteById(Long id){
        this.profesorRepository.deleteById(id);
    }

    //LISTAR CURSOS A LOS QUE PERTENECE UN PROFESOR
    /*
    public List<Curso> listarCursos(ProfesorDto p){
        List<Curso> listaCursos;
        if(listaCursos.isEmpty()){
            return new EntityNotFoundException("Profesor con ID: "+p.id()+" no encontrado");
        }
        return listaCursos;
    }
     */
}
