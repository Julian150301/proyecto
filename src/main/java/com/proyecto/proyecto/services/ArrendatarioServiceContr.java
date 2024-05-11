package com.proyecto.proyecto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.dto.ArrendatarioDTO;
import com.proyecto.proyecto.entity.Arrendatario;
import com.proyecto.proyecto.repository.ArrendatarioRepositoryContr;

@Service
public class ArrendatarioServiceContr {
    private final ArrendatarioRepositoryContr arrendatarioRepositorycContr;
    private final ModelMapper modelMapper ;
    @Autowired
    public ArrendatarioServiceContr(ArrendatarioRepositoryContr arrendatarioRepositorycContr, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.arrendatarioRepositorycContr = arrendatarioRepositorycContr;
    }
    
    public ArrendatarioDTO get(long id){
        Optional<Arrendatario> arrendatarioOpt = arrendatarioRepositorycContr.findById(id);
        ArrendatarioDTO arrendatarioDTO = null;
        if(arrendatarioOpt.isPresent()){
            Arrendatario arrendatario = arrendatarioOpt.get();
            arrendatarioDTO = modelMapper.map(arrendatario, ArrendatarioDTO.class);
        }
        return arrendatarioDTO;
    }
    
    public List<ArrendatarioDTO> getAll(){
       List<Arrendatario> arrendatarios = (List<Arrendatario>) arrendatarioRepositorycContr.findAll();
       return arrendatarios.stream()
                           .map(arrendatario -> modelMapper.map(arrendatario, ArrendatarioDTO.class))
                           .collect(Collectors.toList());
    }
    
    public ArrendatarioDTO save(ArrendatarioDTO arrendatarioDTO){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepositorycContr.save(arrendatario);
        return modelMapper.map(arrendatario, ArrendatarioDTO.class);
    }
    
    public ArrendatarioDTO update(ArrendatarioDTO arrendatarioDTO){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepositorycContr.save(arrendatario);
        return modelMapper.map(arrendatario, ArrendatarioDTO.class);
    }
    
    public void delete(Long id){
        arrendatarioRepositorycContr.deleteById(id);
    }
}
