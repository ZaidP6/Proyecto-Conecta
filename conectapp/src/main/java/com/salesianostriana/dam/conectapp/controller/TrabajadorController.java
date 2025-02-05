package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateUsuarioDto;
import com.salesianostriana.dam.conectapp.model.Trabajador;
import com.salesianostriana.dam.conectapp.service.TrabajadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
