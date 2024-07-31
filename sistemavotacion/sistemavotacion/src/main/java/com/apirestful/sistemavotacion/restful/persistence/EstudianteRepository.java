package com.apirestful.sistemavotacion.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestful.sistemavotacion.restful.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
