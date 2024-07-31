package com.apirestful.sistemavotacion.restful.service.crud;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.sistemavotacion.restful.domain.Estudiante;
import com.apirestful.sistemavotacion.restful.dto.v1.EstudianteDTO;
import com.apirestful.sistemavotacion.restful.persistence.EstudianteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudiante -> modelMapper.map(estudiante, EstudianteDTO.class))
                .collect(Collectors.toList());
    }

    public EstudianteDTO find(Long id) {
        return modelMapper.map(estudianteRepository.findById(id).orElse(null), EstudianteDTO.class);
    }

    public EstudianteDTO create(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);
        return modelMapper.map(estudianteRepository.save(estudiante), EstudianteDTO.class);
    }

    public EstudianteDTO update(EstudianteDTO estudianteDTO) {
        if (estudianteRepository.existsById(estudianteDTO.getId())) {
            Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);
            return modelMapper.map(estudianteRepository.save(estudiante), EstudianteDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }
}