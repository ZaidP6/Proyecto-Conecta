package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateUsuarioDto;
import com.salesianostriana.dam.conectapp.error.UsuarioNotFoundException;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.repository.ProfesorRepository;
import com.salesianostriana.dam.conectapp.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;


    //AÑADIR
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
        profesor = profesorRepository.save(profesor);

        System.out.println("Después de guardar usuario: " + usuario);

        return usuario;
    }

    public List<Usuario> findAll() {
        List<Usuario> result = usuarioRepository.findAll();
        if (result.isEmpty()) {
            throw new UsuarioNotFoundException("No se han encontrado usuarios");
        }
        return result;
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado ningún usuario con id: "+id));
    }

    @Transactional
    public Usuario editUserById(CreateUsuarioDto usuarioDto, Long id) {
        return usuarioRepository.findById(id).map(uOld -> {
            uOld.setUserName(usuarioDto.userName());
            uOld.setPassword(usuarioDto.password());

            Profesor profesor = uOld.getProfesor();
            profesor.setNombre(usuarioDto.nombreProfesor());
            profesor.setApellidos(usuarioDto.apellidosProfesor());
            profesor.setEmail(usuarioDto.emailProfesor());
            profesor.setTelefono(usuarioDto.telefonoProfesor());

            profesorRepository.save(profesor);
            return usuarioRepository.save(uOld);
        }).orElseThrow(() -> new UsuarioNotFoundException("Usuario con ID:" + id + " no encontrado"));
    }

}