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
@Table(name="Enderecos")
public class EnderecoEntity {
    @Id
    @SequenceGenerator( name="endereco_sequence", sequenceName = "endereco_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name="rua", nullable = false)
    private String rua;
    @Column(name="numero", nullable = false)
    private String numero;
    @Column(name="cidade", nullable = false)
    private String cidade;
    @Column(name="estado", nullable = false)
    private String estado;

}
