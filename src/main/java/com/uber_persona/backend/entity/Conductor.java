package com.uber_persona.backend.entity;

import com.uber_persona.backend.abstractclasses.Persona;
import com.uber_persona.backend.constants.ConstanteCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteCliente.CONDUCTORES)
public class Conductor extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConductor;

    @Column(name = ConstanteCliente.LICENCIA, nullable = false, length = 1000)
    private String licenciaConducir;
}
