package com.salesianostriana.dam.conectapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private Rol role;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id", unique = true)
    private Profesor profesor;
}
