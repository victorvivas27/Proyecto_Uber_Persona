package com.uber_persona.backend.service;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.entity.Cliente;
import com.uber_persona.backend.exception.ClienteExistenteException;
import com.uber_persona.backend.interfaces.ICliente;
import com.uber_persona.backend.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService implements ICliente {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Override
    public ToClienteSalida crearCliente(ToClienteEntrada toClienteEntrada) {
        Long cedula = toClienteEntrada.getCedula();
        Cliente cliente = modelMapper.map(toClienteEntrada, Cliente.class);
        if (clienteRepository.existsByCedula(cedula)) {
            throw new ClienteExistenteException("La cédula ya existe en el sistema");
        }
        Cliente clienteCreado = clienteRepository.save(cliente);
        LOGGER.info("Cliente creado con ID: " + clienteCreado.getIdCliente());
        ToClienteSalida toClienteSalida = modelMapper.map(clienteCreado, ToClienteSalida.class);
        LOGGER.info("DTO generado: " + toClienteSalida);
        return toClienteSalida;
    }

    @Override
    public List<ToClienteSalida> listarClientes() {
        return List.of();
    }

    @Override
    public ToClienteSalida obtenerClientePorId(Long idCliente) {
        return null;
    }

    @Override
    public ToClienteSalida actualizarCliente(ToClienteModificar toClienteModificar) {
        return null;
    }

    @Override
    public void eliminarCliente(Long idCliente) {

    }
}
