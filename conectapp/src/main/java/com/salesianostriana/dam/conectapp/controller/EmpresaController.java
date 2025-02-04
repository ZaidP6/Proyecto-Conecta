package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateEmpresaDto;
import com.salesianostriana.dam.conectapp.model.Empresa;
import com.salesianostriana.dam.conectapp.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empresa")
@Tag(name = "Empresa", description = "Controlador de empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Operation(summary = "Agrega una empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha agregado una empresa",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Empresa.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {"id": 1, "cif": "A12345678",
                                                "direccion": "Calle Condes de Bustillo 8",
                                                "coordenadas": "0.1234 5.6789",
                                                "nombre": "Empresa 1"}
                                           """
                            )}
                    )})
    })
    @PostMapping
    public ResponseEntity<CreateEmpresaDto> addEmpresa(@RequestBody CreateEmpresaDto nuevaEmpresa) {
           empresaService.save(nuevaEmpresa);
           return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
    }

    @Operation(summary = "Listar todas las empresas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado empresas",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Empresa.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"id": 1, "cif": "A12345678",
                                                "direccion": "Calle Condes de Bustillo 8",
                                                "coordenadas": "0.1234 5.6789",
                                                "nombre": "Empresa 1"},
                                           
                                                {"id": 2, "cif": "B12345678",
                                                "direccion": "Calle Condes de Bustillo 10",
                                                "coordenadas": "0.7894 8.2563",
                                                "nombre": "Empresa 2"}
                                            ]
                                           """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "NO se han encontrado empresas")
    })
    @GetMapping
    public ResponseEntity<List<Empresa>> findAll(){
        List<Empresa> lista = empresaService.findAll();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        }
    }

    @Operation(summary = "Buscar una empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la empresa",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Empresa.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {"id": 1, "cif": "A12345678",
                                                "direccion": "Calle Condes de Bustillo 8",
                                                "coordenadas": "0.1234 5.6789",
                                                "nombre": "Empresa 1"}
                                           """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "NO se ha encontrado la empresa")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findById(id));
        } catch (EntityNotFoundException err){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @Operation(summary = "Editar una empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la empresa y se ha editado con exito",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Empresa.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {"id": 1, "cif": "A12345678",
                                                "direccion": "Calle Condes de Bustillo 8",
                                                "coordenadas": "0.1234 5.6789",
                                                "nombre": "Empresa 1"}
                                           """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "NO se ha encontrado la empresa")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> edit(@PathVariable Long id, @RequestBody CreateEmpresaDto nuevosDatos){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.edit(id, nuevosDatos));
        } catch (EntityNotFoundException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Elimina una empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha eliminado con exito una empresa o no existía desde un principio")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            empresaService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException err){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

}
