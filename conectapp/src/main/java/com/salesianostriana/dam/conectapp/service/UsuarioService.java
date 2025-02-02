package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateUsuarioDto;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Rol;
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
    public Usuario addNew(CreateUsuarioDto createUsuarioDto) {
        Profesor profesor = profesorRepository.findById(createUsuarioDto.profesor().getId())
                .orElseGet(() -> {
                    Profesor nuevoProfesor = new Profesor();
                    nuevoProfesor.setNombre(createUsuarioDto.profesor().getNombre());
                    nuevoProfesor.setApellidos(createUsuarioDto.profesor().getApellidos());
                    nuevoProfesor.setEmail(createUsuarioDto.profesor().getEmail());
                    nuevoProfesor.setTelefono(createUsuarioDto.profesor().getTelefono());
                    nuevoProfesor.setUsuario(null);
                    return profesorRepository.save(nuevoProfesor);
                });

        // Crear el Usuario con los datos del DTO y el Profesor asociado
        Usuario usuario = Usuario.builder()
                .userName(createUsuarioDto.userName())
                .password(createUsuarioDto.password())
                .role(Rol.USER)  // Usamos un rol por defecto (o lo puedes personalizar)
                .profesor(profesor)
                .build();

        // Guardamos el Usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

}