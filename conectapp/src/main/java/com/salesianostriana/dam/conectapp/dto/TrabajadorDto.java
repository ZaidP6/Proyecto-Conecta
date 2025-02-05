package com.salesianostriana.dam.conectapp.dto;

public record TrabajadorDto(
        String nombre,
        String apellidos,
        String email,
        String telefono,
        String area,
        String puesto
) {}