package com.uber_persona.backend.dto.entrada;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ToClienteEntradaTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deberiaPasarValidacionConDatosValidos() {
        ToClienteEntrada dto = new ToClienteEntrada(
                "Juan",
                "Pérez",
                1234567890L
        );
        Set<ConstraintViolation<ToClienteEntrada>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void deberiaPasarSiElNombreEsMenorA2Caracteres() {
        ToClienteEntrada dto = new ToClienteEntrada(
                "J",
                "Pérez",
                1234567890L
        );
        Set<ConstraintViolation<ToClienteEntrada>> violations = validator.validate(dto);
        assertEquals(1, violations.size());
        assertEquals(ConstantesPersona.NOMBRE_SIZE, violations.iterator().next().getMessage());

    }

    @Test
    void deberiaFallarValidacionSiNombreEsNulo() {
        ToClienteEntrada dto = new ToClienteEntrada(
                null,
                "Pérez",
                1234567890L
        );
        Set<ConstraintViolation<ToClienteEntrada>> violations = validator.validate(dto);
        assertEquals(1, violations.size());
        assertEquals(ConstantesPersona.NOMBRE_NOT_NULL, violations.iterator().next().getMessage());
    }

    @Test
    void deberiaFallarValidacionSiCedulaEsInvalida() {
        ToClienteEntrada dto = new ToClienteEntrada(
                "Juan",
                "Pérez",
                12L
        );
        Set<ConstraintViolation<ToClienteEntrada>> violations = validator.validate(dto);
        assertEquals(1, violations.size());
        assertEquals(ConstantesPersona.CEDULA_SIZE, violations.iterator().next().getMessage());
    }
}