package com.salesianostriana.dam.conectapp.dto;

import com.salesianostriana.dam.conectapp.model.Empresa;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record CreateEmpresaDto(
        @NotBlank
        String cif,
        @NotBlank
        String direccion,
        @DecimalMin("0")
        @DecimalMax("180")
        String coordenadas,
        @NotBlank
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
