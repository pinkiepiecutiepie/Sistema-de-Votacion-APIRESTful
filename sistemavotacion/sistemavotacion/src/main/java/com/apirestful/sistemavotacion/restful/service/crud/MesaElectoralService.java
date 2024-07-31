package com.apirestful.sistemavotacion.restful.service.crud;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.sistemavotacion.restful.domain.MesaElectoral;
import com.apirestful.sistemavotacion.restful.dto.v1.MesaElectoralDTO;
import com.apirestful.sistemavotacion.restful.persistence.MesaElectoralRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaElectoralService {

    @Autowired
    private MesaElectoralRepository mesaElectoralRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<MesaElectoralDTO> findAll() {
        return mesaElectoralRepository.findAll()
                .stream()
                .map(mesa -> modelMapper.map(mesa, MesaElectoralDTO.class))
                .collect(Collectors.toList());
    }

    public MesaElectoralDTO find(Long id) {
        return modelMapper.map(mesaElectoralRepository.findById(id).orElse(null), MesaElectoralDTO.class);
    }

    public MesaElectoralDTO create(MesaElectoralDTO mesaElectoralDTO) {
        MesaElectoral mesaElectoral = modelMapper.map(mesaElectoralDTO, MesaElectoral.class);
        return modelMapper.map(mesaElectoralRepository.save(mesaElectoral), MesaElectoralDTO.class);
    }

    public MesaElectoralDTO update(MesaElectoralDTO mesaElectoralDTO) {
        if (mesaElectoralRepository.existsById(mesaElectoralDTO.getId())) {
            MesaElectoral mesaElectoral = modelMapper.map(mesaElectoralDTO, MesaElectoral.class);
            return modelMapper.map(mesaElectoralRepository.save(mesaElectoral), MesaElectoralDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        mesaElectoralRepository.deleteById(id);
    }
}