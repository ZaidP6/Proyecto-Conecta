package com.salesianostriana.dam.conectapp.repository;

import com.salesianostriana.dam.conectapp.model.Empresa;
import com.salesianostriana.dam.conectapp.model.FamiliaProfesional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
