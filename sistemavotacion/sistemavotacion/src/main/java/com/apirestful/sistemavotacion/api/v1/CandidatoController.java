package com.apirestful.sistemavotacion.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apirestful.sistemavotacion.restful.dto.v1.CandidatoDTO;
import com.apirestful.sistemavotacion.restful.service.crud.CandidatoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public ResponseEntity<List<CandidatoDTO>> getAllCandidatos() {
        return new ResponseEntity<>(candidatoService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CandidatoDTO> createCandidato(@RequestBody CandidatoDTO candidatoDTO) {
        return new ResponseEntity<>(candidatoService.create(candidatoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidatoDTO> updateCandidato(@PathVariable Long id, @RequestBody CandidatoDTO candidatoDTO) {
        candidatoDTO.setId(id);
        return new ResponseEntity<>(candidatoService.update(candidatoDTO), HttpStatus.OK);
    }
}