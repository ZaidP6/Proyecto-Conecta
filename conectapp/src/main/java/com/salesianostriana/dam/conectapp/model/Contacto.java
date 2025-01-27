package com.salesianostriana.dam.conectapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resumen;
    private String canal;
    private Date fecha;

    @ManyToMany
    private List<Profesor> listaProfesores;
}
