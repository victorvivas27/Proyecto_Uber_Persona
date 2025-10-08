package com.uber_persona.backend.controller;

import com.uber_persona.backend.dto.entrada.cliente.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.IClienteController;
import com.uber_persona.backend.service.ClienteService;
import com.uber_persona.backend.util.ApiResponse;
import com.uber_persona.backend.util.Va_Cliente;
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
public class ClienteController implements IClienteController {
    private final ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<ApiResponse<ToClienteSalida>> crearCliente(@RequestBody @Valid ToClienteEntrada toClienteEntrada) {
        ToClienteSalida toClienteSalida = clienteService.crearCliente(toClienteEntrada);
        return ApiResponse.build(Va_Cliente.CLIENTE_CREADO, HttpStatus.CREATED, toClienteSalida);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ToClienteSalida>>> listarClientes() {
        List<ToClienteSalida> toClienteSalidas = clienteService.listarClientes();
        return ApiResponse.build(Va_Cliente.LISTA_CLIENTE, HttpStatus.OK, toClienteSalidas);
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ApiResponse<ToClienteSalida>> buscarClienteID(@PathVariable Long idCliente)
            throws ResourceNotFoundException {
        ToClienteSalida toClienteSalida = clienteService.obtenerClientePorId(idCliente);
        return ApiResponse.build(Va_Cliente.CLIENTE_ENCONTRADO, HttpStatus.OK, toClienteSalida);


    }

    @PutMapping()
    public ResponseEntity<ApiResponse<ToClienteSalida>> modificarCLiente(@Valid @RequestBody ToClienteModificar toClienteModificar)
            throws ResourceNotFoundException {
        ToClienteSalida toClienteSalida = clienteService.actualizarCliente(toClienteModificar);
        return ApiResponse.build(Va_Cliente.CLIENTE_MODIFICADO, HttpStatus.OK, toClienteSalida);

    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<ApiResponse<Long>> eliminarCliente(@PathVariable Long idCliente)
            throws ResourceNotFoundException {
        clienteService.eliminarCliente(idCliente);
        return ApiResponse.build(Va_Cliente.CLIENTE_ELIMINADO, HttpStatus.OK, idCliente);

    }
}