package com.salesianostriana.dam.conectapp.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class Persona {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull @Column
    private String nombre;

    @NonNull @Column
    private String apellidos;

    @NonNull @Column
    private String email;
    @NonNull @Column
    private String telefono;

}
