package com.salesianostriana.dam.conectapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profesor extends Persona{

    @OneToOne
    private Usuario usuario;


}
