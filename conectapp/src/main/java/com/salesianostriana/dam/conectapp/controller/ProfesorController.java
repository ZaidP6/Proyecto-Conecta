package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.model.Profesor;
import com.salesianostriana.dam.conectapp.model.Usuario;
import com.salesianostriana.dam.conectapp.service.ProfesorService;
import com.salesianostriana.dam.conectapp.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesor/")
@RequiredArgsConstructor
@Tag(name = "Profesor", description = "Endpoints para la gestión de profesores")
public class ProfesorController {

    private final ProfesorService profesorService;
    private final UsuarioService usuarioService;

    @GetMapping("/")
    @Operation(summary = "Obtener todos los profesores", description = "Devuelve una lista con todos los profesores registrados en la base de datos")
    @ApiResponse(responseCode = "200", description = "Lista de profesores obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron profesores en la base de datos")
    public ResponseEntity<List<Profesor>> listarProfesores(){
        List<Profesor> listaProfesores = profesorService.findAll();
        if (listaProfesores.isEmpty())
            throw new EntityNotFoundException("No se encontraron profesores.");
        return ResponseEntity.status(200).body(listaProfesores);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener profesor por ID", description = "Buscar un profesor por su ID en la base de datos")
    @ApiResponse(responseCode = "200", description = "Profesor encontrado")
    @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Long id) {
        Profesor profesor = profesorService.findById(id);
        return ResponseEntity.ok(profesor);
    }
}
