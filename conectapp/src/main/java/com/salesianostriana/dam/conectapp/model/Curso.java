package com.salesianostriana.dam.conectapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int horasEmpresa;

    @ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Profesor> profesores = new HashSet<>();



}
