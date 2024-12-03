package com.uber_persona.backend.repository;

import com.uber_persona.backend.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("qa")
class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository clienteRepository;
    private Cliente cliente;
    private Cliente cliente2;


    @BeforeEach
    void setUp() {
        clienteRepository.deleteAll();
        cliente = new Cliente();
        cliente.setCedula(123456789L);
        cliente.setNombre("John");
        cliente.setApellido("Doe");
        clienteRepository.save(cliente);
        cliente2 = new Cliente();
        cliente2.setCedula(987654321L);
        cliente2.setNombre("Jane");
        cliente2.setApellido("Smith");
        clienteRepository.save(cliente2);

    }

    @Test
    void deberiaDevolverTrueSiLaCedulaExiste() {
        boolean exists = clienteRepository.existsByCedula(123456789L);
        assertTrue(exists, "La cédula debería existir");
    }

    @Test
    void deberiaDevolverFalseSiLaCedulaNoExiste() {
        boolean exists = clienteRepository.existsByCedula(987654321L);
        assertFalse(exists, "La cédula no debería existir");
    }

    @Test
    void deberiaDevolverFalseSiElClienteConCedulaYIdNoCoincide() {
        boolean exists = clienteRepository.existsByCedulaAndIdClienteNot(123456789L, 1L);
        assertFalse(exists, "No debería encontrar un cliente con la cédula 987654321 y un ID distinto");

    }

    @Test
    void deberiaLanzarExcepcionSiSeInsertaClienteConCedulaDuplicada() {
        Cliente clienteDuplicado = new Cliente();
        clienteDuplicado.setCedula(123456789L);
        clienteDuplicado.setNombre("Jane");
        clienteDuplicado.setApellido("Smith");
        assertThrows(DataIntegrityViolationException.class,
                () -> clienteRepository.save(clienteDuplicado),
                "Debería lanzarse una excepción al intentar guardar un cliente con cédula duplicada");
    }
}