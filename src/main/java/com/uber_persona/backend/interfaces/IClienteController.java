package com.uber_persona.backend.interfaces;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IClienteController {

    ResponseEntity<ApiResponse<ToClienteSalida>> crearCliente(@RequestBody @Valid ToClienteEntrada toClienteEntrada);

    ResponseEntity<ApiResponse<List<ToClienteSalida>>> listarClientes();

    ResponseEntity<ApiResponse<ToClienteSalida>> buscarClienteID(@PathVariable Long idCliente) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<ToClienteSalida>> clienteModificar(@RequestBody @Valid ToClienteModificar toClienteModificar) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<Long>> eliminarCliente(@PathVariable Long idCliente) throws ResourceNotFoundException;
}
