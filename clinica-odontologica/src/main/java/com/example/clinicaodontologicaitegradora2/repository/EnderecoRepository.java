package com.example.clinicaodontologicaitegradora2.repository;

import com.example.clinicaodontologicaitegradora2.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
}