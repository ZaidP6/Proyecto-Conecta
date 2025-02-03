package com.salesianostriana.dam.conectapp.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ContactoPK implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long profesorId;
    private Long trabajadorId;


}
