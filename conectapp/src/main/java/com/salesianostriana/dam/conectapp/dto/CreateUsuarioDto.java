package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;

public record CreateUsuarioDto(
        String userName, String password
) {
    public Usuario toUsuarioCreated(){
        return Usuario.builder()
                .userName(this.userName())
                .password(this.password())
                .role(Rol.USER)
                .build();
    }
}
