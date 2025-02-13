package com.salesianostriana.dam.conectapp.user.dto;

public record TrabajadorDto(
        String nombre,
        String apellidos,
        String email,
        String telefono,
        String area,
        String puesto
) {}