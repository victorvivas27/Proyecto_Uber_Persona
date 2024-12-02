package com.uber_persona.backend.service;

import com.uber_persona.backend.entity.Cliente;
import com.uber_persona.backend.exception.CedulaExistenteException;
import com.uber_persona.backend.repository.ClienteRepository;
import com.uber_persona.backend.util.ConstantesPersona;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteServiceSave {
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public Cliente crearCliente(Cliente cliente) {
        Long cedula = cliente.getCedula();
        if (clienteRepository.existsByCedula(cedula)) {
            throw new CedulaExistenteException(ConstantesPersona.CEDULA_YA_EXISTE);

        }
        Cliente clienteCreado = modelMapper.map(cliente, Cliente.class);
        return clienteRepository.save(cliente);
    }
}
