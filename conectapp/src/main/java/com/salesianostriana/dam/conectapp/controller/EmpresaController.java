package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateEmpresaDto;
import com.salesianostriana.dam.conectapp.dto.GetEmpresaDto;
import com.salesianostriana.dam.conectapp.dto.GetFamiliaProfesionalDto;
import com.salesianostriana.dam.conectapp.model.Empresa;
import com.salesianostriana.dam.conectapp.model.FamiliaProfesional;
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
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<GetEmpresaDto> findAll(){
        return empresaService.findAll().stream().map(GetEmpresaDto::of).toList();
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
    public GetEmpresaDto findById(@PathVariable Long id){
        return GetEmpresaDto.of(empresaService.findById(id));

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
    public GetEmpresaDto edit(@PathVariable Long id, @RequestBody CreateEmpresaDto nuevosDatos){
        return empresaService.edit(id, nuevosDatos);
    }

    @Operation(summary = "Elimina una empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha eliminado con exito una empresa o no existía desde un principio")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        empresaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Listar familias profesionales relacionadas a una empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la empresa y se han listado las familias profesionales",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FamiliaProfesional.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                [
                                                    {
                                                        "id": 1,
                                                        "nombre": "Familia Profesional 1"
                                                    },
                                                    {
                                                        "id": 2,
                                                        "nombre": "Familia Profesional 2"
                                                    }
                                                ]
                                           """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "NO se ha encontrado la empresa o esta no tiene familias profesionales asociadas")
    })
    @GetMapping("/{id}/familiasprof")
    public Set<GetFamiliaProfesionalDto> listarFamiliasProfesionalesEmpresa(@PathVariable Long id){
        return empresaService.listarFamiliasProfesionalesByEmpresa(id).stream().map(GetFamiliaProfesionalDto::of).collect(Collectors.toSet());
    }

}
