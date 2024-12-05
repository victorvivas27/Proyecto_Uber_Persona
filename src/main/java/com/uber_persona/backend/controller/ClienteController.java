package com.uber_persona.backend.controller;

import com.uber_persona.backend.constants.ConstanteCliente;
import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.IClienteController;
import com.uber_persona.backend.service.ClienteService;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api/cliente")
public class ClienteController implements IClienteController {

    private final ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<ToClienteSalida>> crearCliente(
            @RequestBody @Valid ToClienteEntrada toClienteEntrada) {

        ToClienteSalida toClienteSalida = clienteService.crearCliente(toClienteEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteCliente.CLIENTE_CREADO,
                        HttpStatus.CREATED.value(),
                        toClienteSalida
                ));
    }

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<ToClienteSalida>>> listarClientes() {

        List<ToClienteSalida> toClienteSalidas = clienteService.listarClientes();

        ApiResponse<List<ToClienteSalida>> response = new ApiResponse<>(
                ConstanteCliente.LISTA_CLIENTES,
                HttpStatus.OK.value(),
                toClienteSalidas
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/{idCliente}")
    public ResponseEntity<ApiResponse<ToClienteSalida>> buscarClienteID(
            @PathVariable Long idCliente) throws ResourceNotFoundException {

        ToClienteSalida toClienteSalida = clienteService.obtenerClientePorId(idCliente);

        ApiResponse<ToClienteSalida> response = new ApiResponse<>(
                ConstanteCliente.CLIENTE_ENCONTRADO,
                HttpStatus.OK.value(),
                toClienteSalida
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/modificar")
    public ResponseEntity<ApiResponse<ToClienteSalida>> clienteModificar(
            @Valid @RequestBody ToClienteModificar toClienteModificar) throws ResourceNotFoundException {

        ToClienteSalida toClienteSalida = clienteService.actualizarCliente(toClienteModificar);

        ApiResponse<ToClienteSalida> response = new ApiResponse<>(
                ConstanteCliente.CLIENTE_MODIFICADO,
                HttpStatus.OK.value(),
                toClienteSalida
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<ApiResponse<Long>> eliminarCliente(
            @PathVariable Long idCliente) throws ResourceNotFoundException {

        clienteService.eliminarCliente(idCliente);

        ApiResponse<Long> response = new ApiResponse<>(
                ConstanteCliente.CLIENTE_ELIMINADO,
                HttpStatus.OK.value(),
                idCliente
        );

        return ResponseEntity.ok(response);
    }
}