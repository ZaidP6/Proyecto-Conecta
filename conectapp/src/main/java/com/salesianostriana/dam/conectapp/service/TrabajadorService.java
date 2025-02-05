package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.model.Trabajador;
import com.salesianostriana.dam.conectapp.repository.TrabajadorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    //BUSCAR POR ID
    public Trabajador findById(Long id){
        return this.trabajadorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Trabajador con ID: "+id+ " no encontrado."));
    }

    //AÑADIR

    public Trabajador addNew(Trabajador trabajador){

        Trabajador nuevo = Trabajador.builder()
                .nombre(trabajador.getNombre())
                .apellidos(trabajador.getApellidos())
                .email(trabajador.getEmail())
                .telefono(trabajador.getTelefono())
                .area(trabajador.getArea())
                .puesto(trabajador.getPuesto())
                .build();
        trabajadorRepository.save(nuevo);
        return nuevo;
    }
}
