package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public Profesor addNew (Profesor p){

    }
}
