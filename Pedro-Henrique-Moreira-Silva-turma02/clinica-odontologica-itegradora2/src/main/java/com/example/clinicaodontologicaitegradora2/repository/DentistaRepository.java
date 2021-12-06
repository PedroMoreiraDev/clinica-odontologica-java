package com.example.clinicaodontologicaitegradora2.repository;

import com.example.clinicaodontologicaitegradora2.entities.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<DentistaEntity, Integer> {

    }
