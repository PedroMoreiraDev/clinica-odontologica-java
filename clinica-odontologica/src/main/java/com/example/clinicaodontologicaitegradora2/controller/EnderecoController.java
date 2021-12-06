package com.example.clinicaodontologicaitegradora2.controller;

import com.example.clinicaodontologicaitegradora2.entities.EnderecoEntity;
import com.example.clinicaodontologicaitegradora2.repository.EnderecoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private EnderecoRepository enderecoRepository;
    @GetMapping("/listar")
    public List<EnderecoEntity> ListarEndereco() {
        logger.info("===Listando todos os enderecos===");

        return enderecoRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity listarEnderecosById(@PathVariable Integer id) {
        logger.info("===Pesquisando um endereço pelo Id===");
        return ResponseEntity.ok(enderecoRepository.findById(id));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarEndereco(@PathVariable Integer id){
        logger.info("===Deletando um endereço pelo Id===");
        enderecoRepository.deleteById(id);
    }
}
