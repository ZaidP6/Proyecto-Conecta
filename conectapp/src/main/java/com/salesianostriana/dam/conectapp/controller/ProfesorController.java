package com.salesianostriana.dam.conectapp.controller;

import com.salesianostriana.dam.conectapp.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    
}
