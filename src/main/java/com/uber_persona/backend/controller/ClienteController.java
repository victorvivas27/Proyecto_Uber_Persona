package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.service.ClienteService;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<ToClienteSalida>> crearCliente(@Valid @RequestBody ToClienteEntrada toClienteEntrada) {
        ToClienteSalida toClienteSalida = clienteService.crearCliente(toClienteEntrada);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Cliente Creado", HttpStatus.CREATED.value(), toClienteSalida));
    }
}


