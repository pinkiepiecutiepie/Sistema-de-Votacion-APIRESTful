package com.apirestful.sistemavotacion.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestful.sistemavotacion.restful.domain.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}