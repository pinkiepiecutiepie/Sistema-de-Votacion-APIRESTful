package com.apirestful.sistemavotacion.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestful.sistemavotacion.restful.domain.MesaElectoral;

public interface MesaElectoralRepository extends JpaRepository<MesaElectoral, Long> {
}
