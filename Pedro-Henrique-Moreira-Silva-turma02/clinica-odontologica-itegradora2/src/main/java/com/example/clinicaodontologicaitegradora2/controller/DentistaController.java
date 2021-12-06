package com.example.clinicaodontologicaitegradora2.controller;

import com.example.clinicaodontologicaitegradora2.entities.DentistaEntity;
import com.example.clinicaodontologicaitegradora2.entities.PacienteEntity;
import com.example.clinicaodontologicaitegradora2.repository.DentistaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentista")
public class DentistaController {


    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private DentistaRepository dentistaRepository;

    @PostMapping("/salvar")
    public DentistaEntity salvar(@RequestBody DentistaEntity dentista) {
        logger.info("===Salvando dentista===");

        return dentistaRepository.saveAndFlush(dentista);
    }

    @GetMapping("/listar")
    public List<DentistaEntity> ListarDentista() {
        logger.info("===Listando todos os dentistas===");

        return dentistaRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity listarDentistasById(@PathVariable Integer id) {
        logger.info("===Pesquisando dentista por id===");
        return ResponseEntity.ok(dentistaRepository.findById(id));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarDentista(@PathVariable Integer id) {
        logger.info("===Deletando dentista por id===");
        dentistaRepository.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<DentistaEntity> atualizarDentista(@RequestBody DentistaEntity dentista, @PathVariable Integer id) {
        logger.info("===Atualizando dentista por id===");
        Optional<DentistaEntity> dentistaOptional = dentistaRepository.findById(id);
        if (!dentistaOptional.isPresent())
            return ResponseEntity.notFound().build();
        dentista.setId(id);
        dentistaRepository.save(dentista);
        return ResponseEntity.noContent().build();
    }
}
