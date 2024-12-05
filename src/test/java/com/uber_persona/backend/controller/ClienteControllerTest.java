package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.service.ClienteService;
import com.uber_persona.backend.util.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {
    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void testCrearCliente() {
        ToClienteEntrada toClienteEntrada = ToClienteEntrada.builder().build();
        ToClienteSalida toClienteSalida = ToClienteSalida.builder().build();
        when(clienteService.crearCliente(toClienteEntrada)).thenReturn(toClienteSalida);

        ResponseEntity<ApiResponse<ToClienteSalida>> response = clienteController
                .crearCliente(toClienteEntrada);
        assertNotNull(response);
        assertEquals(201, response.getStatusCode().value());
        assertSame(toClienteSalida, response.getBody().getData());
    }

    @Test
    void testListarCliente() {
        List<ToClienteSalida> clienteSalidas = Collections.emptyList();

        ToClienteSalida toClienteSalida = ToClienteSalida.builder().build();
        when(clienteService.listarClientes()).thenReturn(clienteSalidas);
        ResponseEntity<ApiResponse<List<ToClienteSalida>>> responseClientes = clienteController
                .listarClientes();
        assertNotNull(responseClientes);
        assertEquals(200, responseClientes.getStatusCode().value());
        assertEquals(clienteSalidas, responseClientes.getBody().getData());
        assertEquals("Lista de clientes exitosa", responseClientes.getBody().getMessage());
        assertTrue(responseClientes.getBody().getData().isEmpty());
    }

    @Test
    void testClienteBuscarId() throws ResourceNotFoundException {

        ToClienteSalida toClienteSalida = ToClienteSalida.builder().build();

        when(clienteService.obtenerClientePorId(null)).thenReturn(toClienteSalida);

        ResponseEntity<ApiResponse<ToClienteSalida>> buscarClienteId = clienteController
                .buscarClienteID(null);

        assertNotNull(buscarClienteId);
        assertEquals(200, buscarClienteId.getStatusCode().value());
        assertSame(toClienteSalida, buscarClienteId.getBody().getData());
    }

    @Test
    void testClienteModificar() throws ResourceNotFoundException {
        ToClienteModificar toClienteModificar = ToClienteModificar.builder().build();
        ToClienteSalida toClienteSalida = ToClienteSalida.builder().build();

        when(clienteService.actualizarCliente(toClienteModificar)).thenReturn(toClienteSalida);
        ResponseEntity<ApiResponse<ToClienteSalida>> modificarCliente = clienteController
                .clienteModificar(toClienteModificar);

        assertNotNull(toClienteModificar);
        assertEquals(200, modificarCliente.getStatusCode().value());
        assertSame(toClienteSalida, modificarCliente.getBody().getData());
        assertFalse(toClienteModificar.equals(toClienteSalida));
    }

    @Test
    void testClienteEliminar() throws ResourceNotFoundException {
//Long idCliente=1L;
        doNothing().when(clienteService).eliminarCliente(null);
        ResponseEntity<ApiResponse<Long>> eliminarCliente = clienteController
                .eliminarCliente(null);

        assertNotNull(eliminarCliente);
        assertEquals(200, eliminarCliente.getStatusCode().value());
        assertNotNull(eliminarCliente.getBody());
        assertEquals("Cliente eliminado", eliminarCliente.getBody().getMessage());

    }

}