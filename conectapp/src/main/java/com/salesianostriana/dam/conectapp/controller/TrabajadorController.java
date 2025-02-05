package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateUsuarioDto;
import com.salesianostriana.dam.conectapp.dto.TrabajadorDto;
import com.salesianostriana.dam.conectapp.model.Trabajador;
import com.salesianostriana.dam.conectapp.service.TrabajadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajador/")
@RequiredArgsConstructor
@Tag(name = "Trabajador", description = "Endpoints para la gestión de trabajadores")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @PostMapping()
    @Operation(summary = "Crear un trabajador nuevo", description = "Crea un trabajador y lo guarda en la base de datos")
    @ApiResponse(responseCode = "201", description = "Trabajador creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    public ResponseEntity<Trabajador> crear(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos para crear un trabajador",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Trabajador.class),
                    examples = @ExampleObject(
                            name = "Trabajador de ejemplo",
                            value = """
                                        {
                                          "nombre":"Juan",
                                          "apellidos":"Gómez",
                                          "telefono":"635987458",
                                          "email":"juangomez@gmail.com",
                                          "puesto":"director"
                                          "area":"teleco"
                                        }
                                    """
                    )
            )
    )@RequestBody Trabajador nuevo ){
        Trabajador trabajador = trabajadorService.addNew(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(trabajador);

    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los trabajadores", description = "Devuelve una lista con todos los trabajadores registrados en la base de datos")
    @ApiResponse(responseCode = "200", description = "Lista de trabajadores obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron trabajadores en la base de datos")
    public List<Trabajador> findAll() {
        return trabajadorService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un trabajador por ID", description = "Busca un trabajador en la base de datos por su ID")
    @ApiResponse(responseCode = "200", description = "Trabajador encontrado")
    @ApiResponse(responseCode = "404", description = "Trabajador no encontrado")
    public ResponseEntity<Trabajador> buscarPorId(@PathVariable Long id) {
        Trabajador trabajador = trabajadorService.findById(id);
        return ResponseEntity.ok(trabajador);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar un trabajador por ID", description = "Edita un trabajador existente en la base de datos")
    @ApiResponse(responseCode = "200", description = "Trabajador editado correctamente")
    @ApiResponse(responseCode = "404", description = "Trabajador no encontrado")
    public ResponseEntity<Trabajador> editarTrabajador(
            @PathVariable Long id, @Valid @RequestBody TrabajadorDto trabajadorDto) {
        Trabajador updatedTrabajador = trabajadorService.editTrabajadorById(trabajadorDto, id);
        return ResponseEntity.ok(updatedTrabajador);
    }
}
