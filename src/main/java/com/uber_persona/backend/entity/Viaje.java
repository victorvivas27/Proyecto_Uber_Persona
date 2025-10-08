package com.uber_persona.backend.entity;

import com.uber_persona.backend.util.EstadoViaje;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@Table(name = "VIAJES")
@AllArgsConstructor
@NoArgsConstructor
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = true)
    private Conductor conductor;

    private String puntoInicio;

    private String destino;


    private LocalDateTime horaInicio;

    private LocalDateTime horaFin;

    private Double costo;

    @Enumerated(EnumType.STRING)
    private EstadoViaje estado;
}