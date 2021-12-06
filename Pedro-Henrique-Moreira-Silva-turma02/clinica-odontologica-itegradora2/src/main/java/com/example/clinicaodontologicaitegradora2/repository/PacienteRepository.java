package com.example.clinicaodontologicaitegradora2.repository;

import com.example.clinicaodontologicaitegradora2.entities.PacienteEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {

}
