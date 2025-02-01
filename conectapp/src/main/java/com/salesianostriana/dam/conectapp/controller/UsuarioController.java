package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateProfesorWithUserDto;
import com.salesianostriana.dam.conectapp.dto.CreateUsuarioDto;
import com.salesianostriana.dam.conectapp.dto.ProfesorDto;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.service.ProfesorService;
import com.salesianostriana.dam.conectapp.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Usuario> crear(@Valid @RequestBody CreateUsuarioDto nuevoUser){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.addNew(nuevoUser.toUsuarioCreated()));
    }
}
