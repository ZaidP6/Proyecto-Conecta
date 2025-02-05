package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateFpDto;
import com.salesianostriana.dam.conectapp.error.FamiliaProfesionalNotFoundException;
import com.salesianostriana.dam.conectapp.model.FamiliaProfesional;
import com.salesianostriana.dam.conectapp.repository.FamiliaProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamiliaProfesionalService {

    private final FamiliaProfesionalRepository fpRepo;

    public FamiliaProfesional save(CreateFpDto createFpDto){
        return fpRepo.save(createFpDto.toFp());
    }

    public List<FamiliaProfesional> findAll(){
        List<FamiliaProfesional> lista = fpRepo.findAll();
        if(lista.isEmpty()){
            throw new FamiliaProfesionalNotFoundException("No se han encontrado familias profesionales");
        }
        return lista;
    }
}
