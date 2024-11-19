package com.uber_persona.backend.repository;

import com.uber_persona.backend.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    boolean existsByCedula(Long cedula);
    boolean existsByCedulaAndIdConductorNot(Long cedula, Long idConductor);
}
