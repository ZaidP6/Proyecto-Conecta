package com.salesianostriana.dam.conectapp.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador extends Persona{
     private String puesto;
     private String area;

     
}
