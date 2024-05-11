package com.proyecto.proyecto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.dto.ArrendadorDTOConr;
import com.proyecto.proyecto.entity.Arrendador;
import com.proyecto.proyecto.repository.ArrendadorRepositoryContr;

import ch.qos.logback.core.status.Status;

@Service
public class ArrendadorServiceContr {
    ArrendadorRepositoryContr arrendadorRepositoryContr;
    ModelMapper modelMapper;
    @Autowired
    ArrendadorServiceContr(ArrendadorRepositoryContr arrendadorRepositoryContr, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.arrendadorRepositoryContr = arrendadorRepositoryContr;
    }

    public ArrendadorDTOConr get(long id){
        Optional<Arrendador> arrendadorOpt = arrendadorRepositoryContr.findById(id);
        ArrendadorDTOConr arrendadorDTOConr = null;
        if(arrendadorOpt.isPresent()){
            Arrendador arrendador= arrendadorOpt.get();
            arrendadorDTOConr = modelMapper.map(arrendador, ArrendadorDTOConr.class);
        }
        return arrendadorDTOConr;
    }
    public List<ArrendadorDTOConr> get(){
       List<Arrendador> arrendadores = (List<Arrendador>) arrendadorRepositoryContr.findAll();
       List<ArrendadorDTOConr> arrendadorDTOConrs = arrendadores.stream()
                                            .map(arrendador -> modelMapper.map(arrendador, ArrendadorDTOConr.class))
                                            .collect(Collectors.toList());
       return arrendadorDTOConrs;
    }
    public Arrendador getById(Long id){
        Optional<Arrendador> arrendadorOpt = arrendadorRepositoryContr.findById(id);
        if(arrendadorOpt.isPresent()){
            return arrendadorOpt.get();
        }
        return null; // Si no se encuentra ningún arrendador con el ID especificado
    }
    
    public ArrendadorDTOConr  save(ArrendadorDTOConr arrendadorDTOConr){
        Arrendador arrendador = modelMapper.map(arrendadorDTOConr, Arrendador.class);
        arrendador = arrendadorRepositoryContr.save(arrendador);
        return arrendadorDTOConr;
     }
    /*public ArrendadorDTOConr saveUser(ArrendadorDTOConr arrendadorDTOConr){
        User user = modelMapper.map(arrendadorDTOConr, User.class);
        ArrendadorDTOConr arrendadorDTOConr = arrendadorDTOConr.getByCode(arrendadorDTOConr.getContrasena());
        user.setStatus(Status.ACTIVE);
        user.setPassword(arrendadorDTOConr.getPassword());
    }*/

    public ArrendadorDTOConr  update(ArrendadorDTOConr arrendadorDTOConr){
        Arrendador arrendador = modelMapper.map(arrendadorDTOConr, Arrendador.class);
        arrendador = arrendadorRepositoryContr.save(arrendador);
        return modelMapper.map(arrendador, ArrendadorDTOConr.class);
     }
    public void delete(Long id){
        arrendadorRepositoryContr.deleteById(id);
     }
}
