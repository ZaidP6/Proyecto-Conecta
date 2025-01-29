package com.salesianostriana.dam.conectapp.repository;

import com.salesianostriana.dam.conectapp.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
