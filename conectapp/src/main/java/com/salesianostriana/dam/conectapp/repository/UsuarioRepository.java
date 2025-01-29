package com.salesianostriana.dam.conectapp.repository;

import com.salesianostriana.dam.conectapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByUserName(String userName);

    Optional<Usuario> findByUserName(String userName);
}
