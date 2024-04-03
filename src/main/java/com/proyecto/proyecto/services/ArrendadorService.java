package com.proyecto.proyecto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.boot.model.internal.ListBinder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.dto.ArrendadorDTO;
import com.proyecto.proyecto.entity.Arrendador;
import com.proyecto.proyecto.repository.ArrendadorRepository;

@Service
public class ArrendadorService {
    ArrendadorRepository arrendadorRepository;
    ModelMapper modelMapper;
    
    @Autowired
    ArrendadorService(ArrendadorRepository arrendadorRepository, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.arrendadorRepository = arrendadorRepository;
    }
    public ArrendadorDTO get(long id){
        Optional<Arrendador> arrendadorOpt = arrendadorRepository.findById(id);
        ArrendadorDTO arrendadorDTO = null;
        if(arrendadorOpt.isPresent()){
            Arrendador arrendador= arrendadorOpt.get();
            arrendadorDTO = modelMapper.map(arrendador, ArrendadorDTO.class);
        }
        return arrendadorDTO;
    }
    public List<ArrendadorDTO> get(){
       List<Arrendador> arrendadores = (List<Arrendador>) arrendadorRepository.findAll();
       List<ArrendadorDTO> arrendadorDTO = arrendadores.stream()
                                            .map(arrendador -> modelMapper.map(arrendador, ArrendadorDTO.class))
                                            .collect(Collectors.toList());
       return arrendadorDTO;
    }
    public ArrendadorDTO  save(ArrendadorDTO arrendadorDTO){
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);
        return arrendadorDTO;
     }
     public ArrendadorDTO  update(ArrendadorDTO arrendadorDTO){
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);
        return arrendadorDTO;
     }
     public void delete(Long id){
        arrendadorRepository.deleteById(id);
     }
}
