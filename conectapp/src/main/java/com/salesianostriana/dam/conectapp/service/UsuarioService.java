package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateUsuarioDto;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.repository.ProfesorRepository;
import com.salesianostriana.dam.conectapp.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;


    //AÑADIR
    /*
    public Usuario addNew(CreateUsuarioDto createUsuarioDto) {
        Profesor profesor = Profesor.builder()
                .nombre(createUsuarioDto.nombreProfesor())
                .apellidos(createUsuarioDto.apellidosProfesor())
                .email(createUsuarioDto.emailProfesor())
                .telefono(createUsuarioDto.telefonoProfesor())
                .build();

        profesor = profesorRepository.save(profesor);

        Usuario usuario = Usuario.builder()
                .userName(createUsuarioDto.userName())
                .password(createUsuarioDto.password())
                .role(Rol.USER)
                .profesor(profesor)
                .build();

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        System.out.println("Usuario guardado: " + usuarioGuardado);
        return usuarioGuardado;

    }
     */

    @Transactional
    public Usuario addNew(CreateUsuarioDto createUsuarioDto) {
        Profesor profesor = profesorRepository.findByEmail(createUsuarioDto.emailProfesor())
                .orElseGet(() -> {
                    Profesor nuevoProfesor = Profesor.builder()
                            .nombre(createUsuarioDto.nombreProfesor())
                            .apellidos(createUsuarioDto.apellidosProfesor())
                            .email(createUsuarioDto.emailProfesor())
                            .telefono(createUsuarioDto.telefonoProfesor())
                            .build();
                    return profesorRepository.save(nuevoProfesor);
                });


        if (profesor.getUsuario() != null) {
            throw new IllegalStateException("Este profesor ya tiene un usuario asignado.");
        }

        if (usuarioRepository.existsByUserName(createUsuarioDto.userName())) {
            throw new IllegalStateException("El nombre de usuario ya está en uso.");
        }

        Usuario usuario = Usuario.builder()
                .userName(createUsuarioDto.userName())
                .password(createUsuarioDto.password())
                .role(Rol.USER)
                .build();

        profesor.setUsuario(usuario);
        usuario.setProfesor(profesor);

        System.out.println("Antes de guardar usuario: " + usuario);

        usuario = usuarioRepository.save(usuario);

        System.out.println("Después de guardar usuario: " + usuario);

        return usuario;
    }

}