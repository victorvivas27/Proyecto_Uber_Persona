package com.uber_persona.backend.abstractclasses;

import com.uber_persona.backend.constants.ConstantePersona;
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
    @Column(name = ConstantePersona.NOMBRE, length = 100, nullable = false)
    private String nombre;

    @Column(name = ConstantePersona.APELLIDO, length = 100, nullable = false)
    private String apellido;

    @Column(name = ConstantePersona.CEDULA, length = 15, nullable = false, unique = true)
    private Long cedula;
}
