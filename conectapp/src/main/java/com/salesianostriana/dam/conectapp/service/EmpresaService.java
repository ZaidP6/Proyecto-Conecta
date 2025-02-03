package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateEmpresaDto;
import com.salesianostriana.dam.conectapp.model.Empresa;
import com.salesianostriana.dam.conectapp.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public Empresa save(CreateEmpresaDto createEmpresaDto){
        return empresaRepository.save(createEmpresaDto.toEmpresa());
    }

}
