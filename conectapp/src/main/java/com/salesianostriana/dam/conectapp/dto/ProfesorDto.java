package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Usuario;

public record ProfesorDto(
        Long id,
        String nombre,
        String apellidos,
        String email,
        String telefono,
        String userName,
        String rol //realmente hace falta?

) {
    public static ProfesorDto of(Profesor p){
        Usuario u = p.getUsuario();
        return new ProfesorDto(
                p.getId(),
                p.getNombre(),
                p.getApellidos(),
                p.getEmail(),
                p.getTelefono(),
                p.getUsuario().getUserName(),
                p.getUsuario().getRole().name()
        );

    }


}
