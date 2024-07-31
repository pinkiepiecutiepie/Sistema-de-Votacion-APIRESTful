package com.apirestful.sistemavotacion.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apirestful.sistemavotacion.restful.dto.v1.EstudianteDTO;
import com.apirestful.sistemavotacion.restful.service.crud.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> getAllEstudiantes() {
        return new ResponseEntity<>(estudianteService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> createEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        return new ResponseEntity<>(estudianteService.create(estudianteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> updateEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        estudianteDTO.setId(id);
        return new ResponseEntity<>(estudianteService.update(estudianteDTO), HttpStatus.OK);
    }
}
