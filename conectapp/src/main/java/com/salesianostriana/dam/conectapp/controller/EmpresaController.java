package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.dto.CreateEmpresaDto;
import com.salesianostriana.dam.conectapp.model.Empresa;
import com.salesianostriana.dam.conectapp.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<CreateEmpresaDto> addEmpresa(@RequestBody CreateEmpresaDto nuevaEmpresa) {
           empresaService.save(nuevaEmpresa);
           return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
    }

}
