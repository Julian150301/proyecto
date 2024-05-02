package com.proyecto.proyecto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.dto.PropiedadesDTO;
import com.proyecto.proyecto.entity.Propiedades;
import com.proyecto.proyecto.repository.PropiedadesRepsitory;

@Service
public class PropiedadesService {
    private final PropiedadesRepsitory propiedadesRepository;
    private final ModelMapper modelMapper;
    
    @Autowired
    public PropiedadesService(PropiedadesRepsitory proiedadesRepository, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.propiedadesRepository = proiedadesRepository;
    }
    
    public PropiedadesDTO get(long id){
        Optional<Propiedades> propiedadesOpt = propiedadesRepository.findById(id);
        PropiedadesDTO propiedadesDTO = null;
        if(propiedadesOpt.isPresent()){
            Propiedades propiedades = propiedadesOpt.get();
            propiedadesDTO = modelMapper.map(propiedades, PropiedadesDTO.class);
        }
        return propiedadesDTO;
    }
    
    public List<PropiedadesDTO> getAll(){
       List<Propiedades> propiedadess = (List<Propiedades>) propiedadesRepository.findAll();
       return propiedadess.stream()
                           .map(propiedades -> modelMapper.map(propiedades, PropiedadesDTO.class))
                           .collect(Collectors.toList());
    }
    
    public PropiedadesDTO save(PropiedadesDTO propiedadesDTO){
        Propiedades propiedades = modelMapper.map(propiedadesDTO, Propiedades.class);
        propiedades = propiedadesRepository.save(propiedades);
        return modelMapper.map(propiedades, PropiedadesDTO.class);
    }
    
    public PropiedadesDTO update(PropiedadesDTO propiedadesDTO){
        Propiedades propiedades = modelMapper.map(propiedadesDTO, Propiedades.class);
        propiedades = propiedadesRepository.save(propiedades);
        return modelMapper.map(propiedades, PropiedadesDTO.class);
    }
    
    public void delete(Long id){
        propiedadesRepository.deleteById(id);
    }

    // Nuevo método para reservar una propiedad
    public PropiedadesDTO reservarPropiedad(Long id, String reservadaPor) {
        Optional<Propiedades> propiedadesOpt = propiedadesRepository.findById(id);
        if (propiedadesOpt.isPresent()) {
            Propiedades propiedades = propiedadesOpt.get();
            propiedades.setReservada(true);
            propiedades.setReservadaPor(reservadaPor);
            propiedades = propiedadesRepository.save(propiedades);
            return modelMapper.map(propiedades, PropiedadesDTO.class);
        } else {
            throw new IllegalArgumentException("La propiedad con el ID " + id + " no existe.");
        }
    }
    public Propiedades getById(Long id) {
        return propiedadesRepository.findById(id).orElse(null);
    }
    
    public Propiedades save(Propiedades propiedad) {
        return propiedadesRepository.save(propiedad);
    }
}
