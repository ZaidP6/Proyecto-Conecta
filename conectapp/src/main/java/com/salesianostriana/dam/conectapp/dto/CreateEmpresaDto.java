package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Empresa;

public record CreateEmpresaDto(
        Long id,
        String cif,
        String direccion,
        String coordenadas,
        String nombre
) {

    public Empresa toEmpresa(){
        return Empresa.builder()
                .id(id)
                .cif(cif)
                .direccion(direccion)
                .coordenadas(coordenadas)
                .nombre(nombre)
                .build();
    }

}
