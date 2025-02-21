package com.salesianostriana.dam.conectapp.user.repository;

import com.salesianostriana.dam.conectapp.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByUserName(String userName);

    Optional<Usuario> findByUserName(String userName);

}
