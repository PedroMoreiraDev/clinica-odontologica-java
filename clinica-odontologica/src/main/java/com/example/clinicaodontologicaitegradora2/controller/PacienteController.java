package com.example.clinicaodontologicaitegradora2.controller;

import com.example.clinicaodontologicaitegradora2.entities.DentistaEntity;
import com.example.clinicaodontologicaitegradora2.entities.PacienteEntity;
import com.example.clinicaodontologicaitegradora2.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    //fazer um if para verificar se o RG já existe, caso exista, retornar a mensagem de que não é possivel salvar
    //para auxiliar o usuário na identificação
    @PostMapping("/salvar")
    public PacienteEntity salvar(@RequestBody PacienteEntity paciente) {
        logger.debug("===Incluindo um novo paciente===");
        return pacienteRepository.saveAndFlush(paciente);
    }

    @GetMapping("/listar")
    public List<PacienteEntity> ListarPacientes() {
        logger.info("===Listando todos os pacientes===");
        return pacienteRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity listarPacientesById(@PathVariable Integer id) {
        logger.info("===Pesquisando pelo Id do paciente===");
        return ResponseEntity.ok(pacienteRepository.findById(id));

    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPaciente(@PathVariable Integer id){
        logger.info("===Deletando um paciente pelo Id===");
        pacienteRepository.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PacienteEntity> atualizarPaciente(@RequestBody PacienteEntity paciente, @PathVariable Integer id) {
        logger.info("===Atualizando um paciente pelo Id===");
        Optional<PacienteEntity> pacienteOptional = pacienteRepository.findById(id);
        if (!pacienteOptional.isPresent())
            return ResponseEntity.notFound().build();
        paciente.setId(id);
        pacienteRepository.save(paciente);
        return ResponseEntity.noContent().build();
    }

}



