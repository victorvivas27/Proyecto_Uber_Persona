package com.uber_persona.backend.entity;

import com.uber_persona.backend.abstractclasses.Persona;
import com.uber_persona.backend.util.ConstantesCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstantesCliente.CLIENTES)
public class Cliente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
}
