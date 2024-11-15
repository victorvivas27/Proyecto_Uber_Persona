package com.uber_persona.backend.service;

import com.uber_persona.backend.dto.entrada.ToClienteEntrada;
import com.uber_persona.backend.dto.modificar.ToClienteModificar;
import com.uber_persona.backend.dto.salida.ToClienteSalida;
import com.uber_persona.backend.entity.Cliente;
import com.uber_persona.backend.exception.ClienteExistenteException;
import com.uber_persona.backend.exception.ResourceNotFoundException;
import com.uber_persona.backend.interfaces.ICliente;
import com.uber_persona.backend.repository.ClienteRepository;
import com.uber_persona.backend.util.SalidaJson;
import com.uber_persona.backend.util.Va;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService implements ICliente {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Override
    public ToClienteSalida crearCliente(ToClienteEntrada toClienteEntrada) {
        Long cedula = toClienteEntrada.getCedula();
        Cliente cliente = modelMapper.map(toClienteEntrada, Cliente.class);
        if (clienteRepository.existsByCedula(cedula)) {
            throw new ClienteExistenteException(Va.CEDULA_YA_EXISTE);
        }
        Cliente clienteCreado = clienteRepository.save(cliente);
        ToClienteSalida toClienteSalida = modelMapper.map(clienteCreado, ToClienteSalida.class);
        Va.info(Va.CLIENTE + "\n" + SalidaJson.toString(toClienteSalida));
        return toClienteSalida;
    }

    @Override
    public List<ToClienteSalida> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> modelMapper.map(cliente, ToClienteSalida.class)).collect(Collectors.toList());
    }

    @Override
    public ToClienteSalida obtenerClientePorId(Long idCliente) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        ToClienteSalida toClienteSalida = null;
        if (cliente != null) {
            toClienteSalida = modelMapper.map(cliente, ToClienteSalida.class);
        } else {
            throw new ResourceNotFoundException(Va.CLIENTE_ID_NO_ENCONTRADO + idCliente);
        }
        return toClienteSalida;
    }

    @Override
    public ToClienteSalida actualizarCliente(ToClienteModificar toClienteModificar) throws ResourceNotFoundException {
        Long cedula = toClienteModificar.getCedula();
        Cliente cliente = clienteRepository.findById(toClienteModificar.getIdCliente()).orElseThrow(() -> new ResourceNotFoundException(Va.CLIENTE_ID_NO_ENCONTRADO + toClienteModificar.getIdCliente()));
        if (clienteRepository.existsByCedulaAndIdClienteNot(cedula, cliente.getIdCliente())) {
            throw new ClienteExistenteException(Va.CEDULA_YA_EXISTE);
        }
        modelMapper.map(toClienteModificar, cliente);
        clienteRepository.save(cliente);
        ToClienteSalida toClienteSalida = modelMapper.map(cliente, ToClienteSalida.class);
        Va.info(Va.CLIENTE_MODIFICADO + SalidaJson.toString(toClienteSalida));
        return toClienteSalida;
    }

    @Override
    public void eliminarCliente(Long idCliente) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResourceNotFoundException(Va.CLIENTE_ID_NO_ENCONTRADO + idCliente));
        clienteRepository.deleteById(idCliente);
        Va.info(Va.CLIENTE_ELIMINADO + idCliente);
    }

}
