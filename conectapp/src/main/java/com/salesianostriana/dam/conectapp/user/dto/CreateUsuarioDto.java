package com.salesianostriana.dam.conectapp.user.dto;

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
