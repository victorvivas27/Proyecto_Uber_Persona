package com.uber_persona.backend.abstractclasses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    @Column(name = "APELLIDO", length = 100, nullable = false)
    private String apellido;
    @Column(name = "CEDULA", length = 15, nullable = false, unique = true)
    private Long cedula;
}
