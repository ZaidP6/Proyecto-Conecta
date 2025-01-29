package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.ProfesorDto;
import com.salesianostriana.dam.conectapp.model.Curso;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.repository.ProfesorRepository;
import com.salesianostriana.dam.conectapp.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;


    //AÑADIR
    public ProfesorDto addNew(ProfesorDto profesorDto) {
        // Buscar el usuario asociado al profesor
        Usuario usuario = usuarioRepository.findById(profesorDto.id())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        // Crear la entidad Profesor a partir del DTO
        Profesor p = new Profesor();
        p.setNombre(profesorDto.nombre());
        p.setApellidos(profesorDto.apellidos());
        p.setEmail(profesorDto.email());
        p.setTelefono(profesorDto.telefono());
        p.setUsuario(usuario);

        // Guardar en la base de datos y devolver el DTO creado
        return ProfesorDto.of(profesorRepository.save(p));
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
        return this.profesorRepository.findById(id).map(
                pOld -> {
                    pOld.setNombre(p.getNombre());
                    pOld.setApellidos(p.getApellidos());
                    pOld.setEmail(p.getEmail());
                    pOld.setTelefono(p.getTelefono());
                    pOld.setUsuario(usuarioRepository.findById(p.getUsuario().getId()).orElse(null));
                    return profesorRepository.save(pOld);

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
