package com.salesianostriana.dam.conectapp.user.repository;

import com.salesianostriana.dam.conectapp.user.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRespository extends JpaRepository<Curso, Long> {
}
