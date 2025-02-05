package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateFpDto;
import com.salesianostriana.dam.conectapp.model.FamiliaProfesional;
import com.salesianostriana.dam.conectapp.repository.FamiliaProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamiliaProfesionalService {

    private final FamiliaProfesionalRepository fpRepo;

    public FamiliaProfesional save(CreateFpDto createFpDto){
        return fpRepo.save(createFpDto.toFp());
    }

}
