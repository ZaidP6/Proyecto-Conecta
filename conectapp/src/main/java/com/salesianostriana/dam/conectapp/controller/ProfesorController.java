package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateProfesorWithUserDto;
import com.salesianostriana.dam.conectapp.dto.ProfesorDto;
import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @PostMapping()
    public ResponseEntity<ProfesorDto> crearProfesor(@RequestBody Profesor nuevoProfe){
        Profesor profesor = profesorService.addNew(nuevoProfe);
        ProfesorDto profesorDto = ProfesorDto.of(profesor);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profesorDto);
    }
}
