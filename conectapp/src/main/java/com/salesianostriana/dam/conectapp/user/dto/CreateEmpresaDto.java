package com.salesianostriana.dam.conectapp.user.dto;

import com.salesianostriana.dam.conectapp.user.model.Empresa;

public record CreateEmpresaDto(
        String cif,
        String direccion,
        String coordenadas,
        String nombre
) {

    public Empresa toEmpresa(){
        return Empresa.builder()
                .cif(cif)
                .direccion(direccion)
                .coordenadas(coordenadas)
                .nombre(nombre)
                .build();
    }

}
