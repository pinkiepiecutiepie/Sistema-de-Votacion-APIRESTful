package com.apirestful.sistemavotacion.restful.service.crud;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.sistemavotacion.restful.domain.Curso;
import com.apirestful.sistemavotacion.restful.dto.v1.CursoDTO;
import com.apirestful.sistemavotacion.restful.persistence.CursoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<CursoDTO> findAll() {
        return cursoRepository.findAll()
                .stream()
                .map(curso -> modelMapper.map(curso, CursoDTO.class))
                .collect(Collectors.toList());
    }

    public CursoDTO find(Long id) {
        return modelMapper.map(cursoRepository.findById(id).orElse(null), CursoDTO.class);
    }

    public CursoDTO create(CursoDTO cursoDTO) {
        Curso curso = modelMapper.map(cursoDTO, Curso.class);
        return modelMapper.map(cursoRepository.save(curso), CursoDTO.class);
    }

    public CursoDTO update(CursoDTO cursoDTO) {
        if (cursoRepository.existsById(cursoDTO.getId())) {
            Curso curso = modelMapper.map(cursoDTO, Curso.class);
            return modelMapper.map(cursoRepository.save(curso), CursoDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
