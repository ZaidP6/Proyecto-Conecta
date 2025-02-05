package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CursoDto;
import com.salesianostriana.dam.conectapp.dto.CursoGetListaDto;
import com.salesianostriana.dam.conectapp.model.Curso;
import com.salesianostriana.dam.conectapp.service.CursoService;
import com.salesianostriana.dam.conectapp.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso/")
@RequiredArgsConstructor
@Tag(name = "Curso", description = "Endpoints para la gestión de cursos")
public class CursoController {

    private final CursoService cursoService;
    private final ProfesorService profesorService;

    @PostMapping
    @Operation(summary = "Agrega un nuevo curso", description = "Crea un curso y lo guarda en la base de datos")
    @ApiResponse(responseCode = "201", description = "Curso creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    public ResponseEntity<Curso> crear(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos para crear un curso",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CursoDto.class),
                    examples = @ExampleObject(
                            name = "Curso de ejemplo",
                            value = """
                                        {
                                          "nombre": "1DAM",
                                          "horasEmpresa": 365
                                        }
                                    """
                    )
            )
    )@RequestBody CursoDto nuevoCurso) {
        Curso curso = cursoService.addCurso(nuevoCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los cursos", description = "Devuelve una lista con todos los cursos registrados en la base de datos")
    @ApiResponse(responseCode = "200", description = "Lista de cursos obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron cursos en la base de datos")
    public List<CursoGetListaDto> getAllCursos() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener curso por ID", description = "Buscar un curso por su ID en la base de datos")
    @ApiResponse(responseCode = "200", description = "Curso encontrado")
    @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    public CursoDto getCursoById(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        return CursoDto.of(curso);
    }

    @Operation(summary = "Elimina un curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha eliminado un curso con éxito o no existía")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        cursoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
