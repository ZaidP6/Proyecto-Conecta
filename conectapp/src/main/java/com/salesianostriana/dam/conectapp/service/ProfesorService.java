package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.error.ProfesorNotFoundException;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.repository.ProfesorRepository;
import com.salesianostriana.dam.conectapp.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;

    //BUSCAR POR ID
    public Profesor findById(Long id){
        return this.profesorRepository.findById(id).orElseThrow(() -> new ProfesorNotFoundException("Profesor con ID: "+id+ " no encontrado."));
    }

    //BUSCAR TODOS LOS PROFESORES
    public List<Profesor> findAll(){
        List<Profesor> listaProfes = profesorRepository.findAll();
        if (listaProfes.isEmpty()){
            throw new ProfesorNotFoundException("No se han encontrado profesores");
        }
        return listaProfes;

    }

    //EDITAR PROFE BUSCANDO POR ID
    @Transactional
    public Profesor editById(Profesor p, Long id) {
        return profesorRepository.findById(id).map(pOld -> {
            pOld.setNombre(p.getNombre());
            pOld.setApellidos(p.getApellidos());
            pOld.setEmail(p.getEmail());
            pOld.setTelefono(p.getTelefono());

            if (p.getUsuario() != null && p.getUsuario().getId() != null) {
                usuarioRepository.findById(p.getUsuario().getId()).ifPresent(pOld::setUsuario);
            }
            return profesorRepository.save(pOld);
        }).orElseThrow(() -> new ProfesorNotFoundException("Profesor con ID:" + id + " no encontrado"));
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
