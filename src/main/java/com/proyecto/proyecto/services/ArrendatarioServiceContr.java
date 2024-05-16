package com.proyecto.proyecto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.dto.ArrendadorDTOConr;
import com.proyecto.proyecto.dto.ArrendatarioDTOConr;
import com.proyecto.proyecto.entity.Arrendador;
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
    public static String hashPassword(String password) throws IllegalArgumentException {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return BCrypt.hashpw(password, BCrypt.gensalt(12)); 
    }
    
    public ArrendatarioDTOConr get(long id){
        Optional<Arrendatario> arrendatarioOpt = arrendatarioRepositorycContr.findById(id);
        ArrendatarioDTOConr arrendatarioDTOConr = null;
        if(arrendatarioOpt.isPresent()){
            Arrendatario arrendatario = arrendatarioOpt.get();
            arrendatarioDTOConr = modelMapper.map(arrendatario, ArrendatarioDTOConr.class);
        }
        return arrendatarioDTOConr;
    }
    
    public List<ArrendatarioDTOConr> getAll(){
       List<Arrendatario> arrendatarios = (List<Arrendatario>) arrendatarioRepositorycContr.findAll();
       return arrendatarios.stream()
                           .map(arrendatario -> modelMapper.map(arrendatario, ArrendatarioDTOConr.class))
                           .collect(Collectors.toList());
    }
    
    public ArrendatarioDTOConr save(ArrendatarioDTOConr arrendatarioDTOConr){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTOConr, Arrendatario.class);
        arrendatario = arrendatarioRepositorycContr.save(arrendatario);
        return modelMapper.map(arrendatario, ArrendatarioDTOConr.class);
    }
    public ArrendatarioDTOConr saveContrasena(ArrendatarioDTOConr arrendatarioDTOContra) {
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTOContra, Arrendatario.class);
        String hashedPassword = hashPassword(arrendatarioDTOContra.getContrasena()); 
        arrendatario.setContrasena(hashedPassword);
        arrendatario = arrendatarioRepositorycContr.save(arrendatario); 
        return modelMapper.map(arrendatario, ArrendatarioDTOConr.class);
      }
    
    public ArrendatarioDTOConr update(ArrendatarioDTOConr arrendatarioDTOConr){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTOConr, Arrendatario.class);
        arrendatario = arrendatarioRepositorycContr.save(arrendatario);
        return modelMapper.map(arrendatario, ArrendatarioDTOConr.class);
    }
    
    public void delete(Long id){
        arrendatarioRepositorycContr.deleteById(id);
    }
    
}
