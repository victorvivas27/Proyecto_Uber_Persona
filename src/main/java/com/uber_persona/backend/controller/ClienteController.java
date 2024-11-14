package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.service.ClienteService;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hibernate.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/cliente")
public class ClienteController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearCliente(@RequestBody @Valid ToClienteEntrada toClienteEntrada) {
        ToClienteSalida toClienteSalida = clienteService.crearCliente(toClienteEntrada);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Cliente Creado", HttpStatus.CREATED.value(), toClienteSalida));
    }

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<ToClienteSalida>>> listarClientes() {
        try {
            List<ToClienteSalida> toClienteSalidas = clienteService.listarClientes();
            ApiResponse<List<ToClienteSalida>> response =
                    new ApiResponse<>("Lista de clientes exitosa", HttpStatus.OK.value(), toClienteSalidas);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (MappingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), null));
        }
    }
}


