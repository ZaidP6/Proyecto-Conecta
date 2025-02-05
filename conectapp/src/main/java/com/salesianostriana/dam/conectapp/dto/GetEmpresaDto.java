package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Empresa;

public record GetEmpresaDto(
        Long id,
        String cif,
        String direccion,
        String coordenadas,
        String nombre
){
    public static GetEmpresaDto of (Empresa e){
        return new GetEmpresaDto(
                e.getId(),
                e.getCif(),
                e.getDireccion(),
                e.getCoordenadas(),
                e.getNombre()
        );
    }
}
