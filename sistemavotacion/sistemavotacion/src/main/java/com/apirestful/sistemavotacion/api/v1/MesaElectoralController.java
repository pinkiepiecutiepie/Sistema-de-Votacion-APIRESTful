package com.apirestful.sistemavotacion.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apirestful.sistemavotacion.restful.dto.v1.MesaElectoralDTO;
import com.apirestful.sistemavotacion.restful.service.crud.MesaElectoralService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mesas")
public class MesaElectoralController {

    @Autowired
    private MesaElectoralService mesaElectoralService;

    @GetMapping
    public ResponseEntity<List<MesaElectoralDTO>> getAllMesas() {
        return new ResponseEntity<>(mesaElectoralService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MesaElectoralDTO> createMesa(@RequestBody MesaElectoralDTO mesaElectoralDTO) {
        return new ResponseEntity<>(mesaElectoralService.create(mesaElectoralDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesaElectoralDTO> updateMesa(@PathVariable Long id, @RequestBody MesaElectoralDTO mesaElectoralDTO) {
        mesaElectoralDTO.setId(id);
        return new ResponseEntity<>(mesaElectoralService.update(mesaElectoralDTO), HttpStatus.OK);
    }
}
