package com.example.clinicaodontologicaitegradora2.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Dentistas")

public class DentistaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="nome", nullable = false)
    private String nome;
    @Column(name="sobrenome", nullable = false)
    private String sobrenome;
    @Column(name="numeroRegistro", nullable = false, unique = true)
    private String numeroRegistro;

}
