package com.uber_persona.backend;

import com.uber_persona.backend.dto.entrada.cliente.ToClienteEntrada;
import com.uber_persona.backend.entity.Cliente;
import com.uber_persona.backend.util.Va_Persona;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTestUnitario {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // ----------------------------------------------------
    // TESTS POSITIVOS
    // ----------------------------------------------------

    /**
     * TC01 - Datos completos y válidos
     */
    @Test
    @DisplayName("TC01 - Debería crear un cliente válido correctamente")
    void crearClienteValido() {
        // Arrange & Act
        Cliente cliente = Cliente.builder()
                .idCliente(1L)
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        // Assert
        assertAll(
                () -> assertEquals(1L, cliente.getIdCliente()),
                () -> assertEquals(Va_Persona.NOMBRE_VALIDO, cliente.getNombre()),
                () -> assertEquals(Va_Persona.APELLIDO_VALIDO, cliente.getApellido()),
                () -> assertEquals(Va_Persona.CEDULA_VALIDA, cliente.getCedula())
        );
    }

    // ----------------------------------------------------
    // TESTS NEGATIVOS - VALIDACIONES DTO
    // ----------------------------------------------------

    /**
     * TC02 - Todos los campos null
     */
    @Test
    @DisplayName("TC02 - Debe fallar si todos los campos son null")
    void camposNull_enToClienteEntrada_deberiaFallarYDispararLasTresValidaciones() {
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(null)
                .apellido(null)
                .cedula(null)
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        Map<String, String> errores = violaciones.stream()
                .collect(Collectors.toMap(
                        v -> v.getPropertyPath().toString(),
                        ConstraintViolation::getMessage
                ));

        assertEquals(3, errores.size(), "Debe haber 3 validaciones fallidas");

    }

    /**
     * TC03 - Nombre null
     */
    @Test
    @DisplayName("TC03 - Debería fallar si el nombre es null")
    void nombreNull_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        // Arrange
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(null)
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        // Act
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        // Assert
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.NOMBRE_NOT_NULL, violaciones.iterator().next().getMessage());
    }

    /**
     * TC04 - Nombre vacío
     */
    @Test
    @DisplayName("TC04 - Debería fallar si el nombre está vacío")
    void nombreVacio_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        // Arrange
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre("")
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        // Act
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        // Assert
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.NOMBRE_PATTERN, violaciones.iterator().next().getMessage());
    }

    /**
     * TC05 - Nombre mayor a 50 caracteres
     */
    @Test
    @DisplayName("TC05 - Debería fallar si el nombre tiene más de 50 caracteres")
    void nombreMayorA50_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        // Arrange
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre("Victorgtbsnahystbahnamkdgbahydnbajklsnchyanacmjsyay")
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        // Act
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        // Assert
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.NOMBRE_PATTERN, violaciones.iterator().next().getMessage());
    }

    /**
     * TC06 - Apellido null
     */
    @Test
    @DisplayName("TC06 - Debería fallar si el apellido es null")
    void apellidoNull_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        // Arrange
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido(null)
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        // Act
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        // Assert
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.APELLIDO_NOT_NULL, violaciones.iterator().next().getMessage());
    }

    /**
     * TC07 - Apellido vacío
     **/

    @Test
    @DisplayName("TC07 - Debería fallar si el apellido está vacío")
    void TC07_apellidoVacio_enToClienteEntrada() {
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido("")
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.APELLIDO_PATTERN, violaciones.iterator().next().getMessage());
    }

    /**
     * TC08 - Apellido mayor a 100 caracteres
     */
    @Test
    @DisplayName("TC08 - Debería fallar si el apellido tiene más de 100 caracteres")
    void TC08_apellidoMayorA100_enToClienteEntrada() {
        String apellidoLargo = "V".repeat(101);

        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido(apellidoLargo)
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.APELLIDO_PATTERN, violaciones.iterator().next().getMessage());
    }

    /**
     * TC09 - Apellido con caracteres inválidos
     */
    @Test
    @DisplayName("TC09 - Debería fallar si el apellido contiene caracteres inválidos")
    void apellidoConCaracteresInvalidos_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido("V1v@s!")
                .cedula(Va_Persona.CEDULA_VALIDA)
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.APELLIDO_PATTERN, violaciones.iterator().next().getMessage());
    }

    /**
     * TC10 - Cédula null
     */
    @Test
    @DisplayName("TC10 - Debería fallar si la cédula es null")
    void cedulaNull_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula(null)
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.CEDULA_NOT_NULL, violaciones.iterator().next().getMessage());
    }

    /**
     * TC11 - Cédula con letras
     **/
    @Test
    @DisplayName("TC11 - Debería fallar si la cédula contiene letras")
    void TC11_cedulaConLetras_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula("233CAVAS")
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.CEDULA_PATTERN, violaciones.iterator().next().getMessage());
    }

    /**
     * TC12 - Cédula con más de 10 dígitos
     */
    @Test
    @DisplayName("TC12 - Debería fallar si la cédula tiene más de 10 dígitos")
    void cedulaMayorA10_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula("1236789634")
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.CEDULA_SIZE, violaciones.iterator().next().getMessage());
    }

    /**
     * TC13 - Cédula con menos de 8 dígitos
     */
    @Test
    @DisplayName("TC13 - Debería fallar si la cédula tiene menos de 8 dígitos")
    void TC12_cedulaMenorA8_enToClienteEntrada_deberiaFallarYDispararValidacion() {
        ToClienteEntrada cliente = ToClienteEntrada.builder()
                .nombre(Va_Persona.NOMBRE_VALIDO)
                .apellido(Va_Persona.APELLIDO_VALIDO)
                .cedula("123456")
                .build();
        Set<ConstraintViolation<ToClienteEntrada>> violaciones = validator.validate(cliente);
        assertFalse(violaciones.isEmpty());
        assertEquals(Va_Persona.CEDULA_SIZE, violaciones.iterator().next().getMessage());
    }
}
