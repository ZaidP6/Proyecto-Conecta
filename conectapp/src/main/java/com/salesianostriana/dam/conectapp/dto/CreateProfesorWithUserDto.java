package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;

public record CreateProfesorWithUserDto(
        String nombre,
        String apellidos,
        String email,
        String telefono,
        String userName,
        String password,
        Rol role
) {

    public Profesor toProfesorCreated(CreateProfesorWithUserDto createProfesorWithUserDto) {

        Usuario usuario = Usuario.builder()
                .userName(createProfesorWithUserDto.userName())
                .password(createProfesorWithUserDto.password())
                .role(createProfesorWithUserDto.role())
                .build();
        return Profesor.builder()
                .nombre(createProfesorWithUserDto.nombre())
                .apellidos(createProfesorWithUserDto.apellidos())
                .email(createProfesorWithUserDto.email())
                .telefono(createProfesorWithUserDto.telefono())
                .usuario(usuario)
                .build();
    }
}
