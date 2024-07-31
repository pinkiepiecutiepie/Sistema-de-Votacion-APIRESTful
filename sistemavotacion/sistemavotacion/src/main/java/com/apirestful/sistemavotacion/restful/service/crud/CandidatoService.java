package com.apirestful.sistemavotacion.restful.service.crud;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.sistemavotacion.restful.domain.Candidato;
import com.apirestful.sistemavotacion.restful.dto.v1.CandidatoDTO;
import com.apirestful.sistemavotacion.restful.persistence.CandidatoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<CandidatoDTO> findAll() {
        return candidatoRepository.findAll()
                .stream()
                .map(candidato -> modelMapper.map(candidato, CandidatoDTO.class))
                .collect(Collectors.toList());
    }

    public CandidatoDTO find(Long id) {
        return modelMapper.map(candidatoRepository.findById(id).orElse(null), CandidatoDTO.class);
    }

    public CandidatoDTO create(CandidatoDTO candidatoDTO) {
        Candidato candidato = modelMapper.map(candidatoDTO, Candidato.class);
        return modelMapper.map(candidatoRepository.save(candidato), CandidatoDTO.class);
    }

    public CandidatoDTO update(CandidatoDTO candidatoDTO) {
        if (candidatoRepository.existsById(candidatoDTO.getId())) {
            Candidato candidato = modelMapper.map(candidatoDTO, Candidato.class);
            return modelMapper.map(candidatoRepository.save(candidato), CandidatoDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        candidatoRepository.deleteById(id);
    }
}
