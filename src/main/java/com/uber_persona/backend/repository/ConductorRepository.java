package com.uber_persona.backend.repository;

import com.uber_persona.backend.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    boolean existsByCedula(String cedula);

    boolean existsByCedulaAndIdConductorNot(String cedula, Long idConductor);
}
