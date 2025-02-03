package com.salesianostriana.dam.conectapp.repository;

import com.salesianostriana.dam.conectapp.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByEmail(String s);
}
