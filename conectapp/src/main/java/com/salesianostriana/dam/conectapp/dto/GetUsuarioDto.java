package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;
import org.springframework.context.support.BeanDefinitionDsl;

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
