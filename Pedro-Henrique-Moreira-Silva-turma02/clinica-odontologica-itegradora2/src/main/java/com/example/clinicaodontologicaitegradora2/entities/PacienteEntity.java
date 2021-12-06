package com.example.clinicaodontologicaitegradora2.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Pacientes")

public class PacienteEntity {

    @Id
    @SequenceGenerator( name="paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name="nome", nullable = false)
    private String nome;
    @Column(name="sobrenome", nullable = false)
    private String sobrenome;
    @Column(name="rg", nullable = false, unique = true)
    private String rg;
    @Column(name="dataCadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;


}
