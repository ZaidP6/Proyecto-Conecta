package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;
import lombok.NonNull;

public record CreateProfesorWithUserDto(

        @NonNull
        Profesor profesor,
        @NonNull
        String userName,
        @NonNull
        String password,
        @NonNull
        Rol role
) {

    public Usuario toUsuarioCreated() {

        return Usuario.builder()
                .userName(userName)
                .password(password)
                .role(Rol.valueOf("USER"))
                .profesor(profesor)
                .build();
    }
}
