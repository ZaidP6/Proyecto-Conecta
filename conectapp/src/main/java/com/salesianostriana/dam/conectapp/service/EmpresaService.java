package com.salesianostriana.dam.conectapp.service;

import com.salesianostriana.dam.conectapp.dto.CreateEmpresaDto;
import com.salesianostriana.dam.conectapp.error.EmpresaNotFoundException;
import com.salesianostriana.dam.conectapp.model.Empresa;
import com.salesianostriana.dam.conectapp.repository.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public Empresa save(CreateEmpresaDto createEmpresaDto){
        empresaRepository.save(createEmpresaDto.toEmpresa());
        return createEmpresaDto.toEmpresa();
    }

    public List<Empresa> findAll(){
        List<Empresa> lista = empresaRepository.findAll();
        if(lista.isEmpty()){
            throw new EmpresaNotFoundException("No se han encontrado empresas");
        }
        return lista;
    }

    public Empresa findById(Long id){
        return empresaRepository.findById(id).orElseThrow(() -> new EmpresaNotFoundException("No se ha encontrado ninguna empresa con id: " +id));
    }

    public Empresa edit(Long id, CreateEmpresaDto nuevosDatos){
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new EmpresaNotFoundException("No se ha encontrado ninguna empresa con id: " +id));
        empresa.setCif(nuevosDatos.cif());
        empresa.setDireccion(nuevosDatos.direccion());
        empresa.setNombre(nuevosDatos.nombre());
        empresa.setCoordenadas(nuevosDatos.coordenadas());

        empresaRepository.save(empresa);

        return empresa;
    }

    public void delete(Long id){
        empresaRepository.deleteById(id);
    }

}
