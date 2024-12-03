package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.service.ClienteService;
import com.uber_persona.backend.util.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {
    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void testCrearCliente(){
        ToClienteEntrada toClienteEntrada = ToClienteEntrada.builder().build();
        ToClienteSalida toClienteSalida = ToClienteSalida.builder().build();
        when(clienteService.crearCliente(toClienteEntrada)).thenReturn(toClienteSalida);


        ResponseEntity<ApiResponse<ToClienteSalida>> response = clienteController.crearCliente(toClienteEntrada);
        assertNotNull(response);
        assertEquals(201,response.getStatusCode().value());
        assertSame(toClienteSalida,response.getBody().getData());
    }


}