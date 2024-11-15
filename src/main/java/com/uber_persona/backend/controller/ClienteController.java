package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.service.ClienteService;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/cliente")
public class ClienteController {
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
        List<ToClienteSalida> toClienteSalidas = clienteService.listarClientes();
        ApiResponse<List<ToClienteSalida>> response =
                new ApiResponse<>("Lista de clientes exitosa", HttpStatus.OK.value(), toClienteSalidas);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/{idCliente}")
    public ResponseEntity<ApiResponse<ToClienteSalida>> buscarClienteID(@PathVariable Long idCliente) throws ResourceNotFoundException {
        ToClienteSalida toClienteSalida = clienteService.obtenerClientePorId(idCliente);
        ApiResponse<ToClienteSalida> response = new ApiResponse<>(
                "Cliente encontrado", HttpStatus.OK.value(), toClienteSalida);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/modificar")
    public ResponseEntity<ApiResponse<ToClienteSalida>> modificarCLiente(@Valid @RequestBody ToClienteModificar toClienteModificar) throws ResourceNotFoundException {
        ToClienteSalida toClienteSalida = clienteService.actualizarCliente(toClienteModificar);
        ApiResponse<ToClienteSalida> response = new ApiResponse<>(
                "Cliente modificado", HttpStatus.OK.value(), toClienteSalida);
        return ResponseEntity.ok(response);
    }

}


