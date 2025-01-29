package com.salesianostriana.dam.conectapp.repository;

import com.salesianostriana.dam.conectapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
