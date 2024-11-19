package com.uber_persona.backend.abstractclasses;

import com.uber_persona.backend.util.Va_Persona;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Persona {
    @Column(name = Va_Persona.NOMBRE, length = 100, nullable = false)
    private String nombre;
    @Column(name = Va_Persona.APELLIDO, length = 100, nullable = false)
    private String apellido;
    @Column(name = Va_Persona.CEDULA, length = 15, nullable = false, unique = true)
    private Long cedula;
}
