package com.uber_persona.backend.service;

import com.uber_persona.backend.constants.ConstanteCliente;
import com.uber_persona.backend.constants.ConstantePersona;
import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.entity.Cliente;
import com.uber_persona.backend.exception.CedulaExistenteException;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.ICliente;
import com.uber_persona.backend.repository.ClienteRepository;
import com.uber_persona.backend.util.SalidaJson;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;
    private final ClienteServiceSave clienteServiceSave;

    @Override
    public ToClienteSalida crearCliente(ToClienteEntrada toClienteEntrada) {
        Cliente cliente = modelMapper.map(toClienteEntrada, Cliente.class);
        Cliente clienteCreado = clienteServiceSave.crearCliente(cliente);

        ToClienteSalida toClienteSalida = modelMapper.map(clienteCreado, ToClienteSalida.class);

        LOGGER.info(ConstanteCliente.CLIENTE + "\n" + SalidaJson.toString(toClienteSalida));

        return toClienteSalida;
    }

    @Override
    public List<ToClienteSalida> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ToClienteSalida.class))
                .toList();
    }

    @Override
    public ToClienteSalida obtenerClientePorId(Long idCliente) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);

        ToClienteSalida toClienteSalida = null;

        if (cliente != null) {
            toClienteSalida = modelMapper.map(cliente, ToClienteSalida.class);
        } else {
            throw new ResourceNotFoundException(ConstanteCliente.CLIENTE_ID_NO_ENCONTRADO + idCliente);
        }

        return toClienteSalida;
    }

    @Override
    public ToClienteSalida actualizarCliente(ToClienteModificar toClienteModificar) throws ResourceNotFoundException {
        Long cedula = toClienteModificar.getCedula();

        Cliente cliente = clienteRepository.findById(toClienteModificar.getIdCliente())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteCliente.CLIENTE_ID_NO_ENCONTRADO + toClienteModificar.getIdCliente()
                ));

        if (clienteRepository.existsByCedulaAndIdClienteNot(cedula, cliente.getIdCliente())) {
            throw new CedulaExistenteException(ConstantePersona.CEDULA_EXISTE);
        }

        modelMapper.map(toClienteModificar, cliente);
        clienteRepository.save(cliente);

        ToClienteSalida toClienteSalida = modelMapper.map(cliente, ToClienteSalida.class);

        LOGGER.info(ConstanteCliente.CLIENTE + SalidaJson.toString(toClienteSalida));

        return toClienteSalida;
    }

    @Override
    public void eliminarCliente(Long idCliente) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteCliente.CLIENTE_ID_NO_ENCONTRADO + idCliente
                ));

        clienteRepository.deleteById(idCliente);

        LOGGER.info(ConstanteCliente.CLIENTE + idCliente);
    }
}
