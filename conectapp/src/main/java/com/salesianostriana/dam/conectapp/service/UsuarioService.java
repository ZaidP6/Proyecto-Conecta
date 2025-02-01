package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.repository.ProfesorRepository;
import com.salesianostriana.dam.conectapp.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;


    //AÑADIR
    public Usuario addNew(Usuario usuario) {
        Profesor profe = profesorRepository.save(usuario.getProfesor());
        usuario.setProfesor(profe);

        return usuarioRepository.save(Usuario.builder()
                        .userName(usuario.getUserName())
                        .password(usuario.getPassword())
                        .role(usuario.getRole())
                        .profesor(usuario.getProfesor())
                .build());

    }
}
