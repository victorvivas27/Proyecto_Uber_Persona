package com.uber_persona.backend.entity;

import com.uber_persona.backend.abstractclasses.Persona;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENTES")
public class Cliente extends Persona {
    public Cliente() {
    }
}