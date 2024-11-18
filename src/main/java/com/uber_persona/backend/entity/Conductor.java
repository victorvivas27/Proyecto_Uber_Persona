package com.uber_persona.backend.entity;

import com.uber_persona.backend.abstractclasses.Persona;
import com.uber_persona.backend.util.Va_Conductor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Va_Conductor.CONDUCTORES)
public class Conductor extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConductor;
    @Column(name = "LICENCIA_CONDUCIR", nullable = false, length = 100)
    private String licenciaConducir;
}
