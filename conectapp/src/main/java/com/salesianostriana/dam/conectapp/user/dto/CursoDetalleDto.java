package com.salesianostriana.dam.conectapp.user.dto;

import java.util.List;

public record CursoDetalleDto(
        Long id, String nombre,
        int horasEmpresa,
        List<ProfesorDto> profesores
) {}

