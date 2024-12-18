package com.uber_persona.backend.entity;

import com.uber_persona.backend.abstractclasses.Persona;
import com.uber_persona.backend.util.Va_Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Va_Cliente.CLIENTES)
public class Cliente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
}
