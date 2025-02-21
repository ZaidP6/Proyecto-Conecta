package com.salesianostriana.dam.conectapp.user.dto;

import com.salesianostriana.dam.conectapp.user.model.Rol;
import com.salesianostriana.dam.conectapp.user.model.Usuario;

public record GetUsuarioDto(
        Long id,
        String userName,
        Rol role
) {

    public static GetUsuarioDto of (Usuario u){
        return new GetUsuarioDto(
                u.getId(),
                u.getUserName(),
                u.getRole()
        );
    }

}
