package com.apirestful.sistemavotacion.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apirestful.sistemavotacion.restful.dto.v1.CursoDTO;
import com.apirestful.sistemavotacion.restful.service.crud.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursos() {
        return new ResponseEntity<>(cursoService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoDTO) {
        return new ResponseEntity<>(cursoService.create(cursoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        cursoDTO.setId(id);
        return new ResponseEntity<>(cursoService.update(cursoDTO), HttpStatus.OK);
    }
}
