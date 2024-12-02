package com.uber_persona.backend.entity;

import com.uber_persona.backend.abstractclasses.Persona;
import com.uber_persona.backend.util.ConstantesConductor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstantesConductor.CONDUCTORES)
public class Conductor extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConductor;
    @Column(name = ConstantesConductor.LICENCIA, nullable = false, length = 100)
    private String licenciaConducir;
}
