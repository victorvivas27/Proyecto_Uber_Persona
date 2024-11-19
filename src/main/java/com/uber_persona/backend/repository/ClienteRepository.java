package com.uber_persona.backend.repository;

import com.uber_persona.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCedula(Long cedula);
    boolean existsByCedulaAndIdClienteNot(Long cedula, Long idCliente);
}
