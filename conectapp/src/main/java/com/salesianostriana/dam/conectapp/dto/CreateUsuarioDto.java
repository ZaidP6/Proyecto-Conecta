package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Rol;
import com.salesianostriana.dam.conectapp.model.Usuario;

public record CreateUsuarioDto(
        String userName, String password,
        String nombreProfesor, String apellidosProfesor,
        String emailProfesor, String telefonoProfesor
) {
    /*
    public Usuario toUsuarioCreated(){
        return Usuario.builder()
                .userName(this.userName())
                .password(this.password())
                .role(Rol.USER)
                .profesor(this.profesor)
                .build();
    }
     */
}
