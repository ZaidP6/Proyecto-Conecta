package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateFpDto;
import com.salesianostriana.dam.conectapp.model.Empresa;
import com.salesianostriana.dam.conectapp.service.FamiliaProfesionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fp")
public class FamiliaProfesionalController {

    private final FamiliaProfesionalService fpService;

    @Operation(summary = "Agrega una Familia Profesional")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha agregado una familia profesional",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Empresa.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {
                                                    "nombre": "Familia Profesional 1",
                                                }
                                           """
                            )}
                    )})
    })
    @PostMapping
    public ResponseEntity<CreateFpDto> addFp(@RequestBody CreateFpDto nuevaFp){
        fpService.save(nuevaFp);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFp);
    }

}
