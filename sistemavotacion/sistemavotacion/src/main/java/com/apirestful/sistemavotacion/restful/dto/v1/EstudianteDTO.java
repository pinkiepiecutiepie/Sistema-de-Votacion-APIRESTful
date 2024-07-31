package com.apirestful.sistemavotacion.restful.dto.v1;

import lombok.Data;

@Data
public class EstudianteDTO {

    private Long id;
    private String nombre;
    private String cedula;
    private CursoDTO curso;
}
