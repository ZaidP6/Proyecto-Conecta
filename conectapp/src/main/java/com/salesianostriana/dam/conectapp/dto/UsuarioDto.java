package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;

public record UsuarioDto(
        Long id,
        String userName,
        Rol role
) {
    public static UsuarioDto of(Usuario u){
        return new UsuarioDto(
                u.getId(),
                u.getUserName(),
                u.getRole());
    }
}
