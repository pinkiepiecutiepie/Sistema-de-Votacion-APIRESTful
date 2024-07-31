package com.apirestful.sistemavotacion.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestful.sistemavotacion.restful.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}