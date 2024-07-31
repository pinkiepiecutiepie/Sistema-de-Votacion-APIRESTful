package com.apirestful.sistemavotacion.restful.dto.v1;

import lombok.Data;

@Data
public class CandidatoDTO {

    private Long id;
    private String nombre;
    private CursoDTO curso;
}
