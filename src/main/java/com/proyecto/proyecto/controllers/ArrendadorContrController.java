package com.proyecto.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.ArrendadorDTOConr;
import com.proyecto.proyecto.services.ArrendadorServiceContr;

@RestController
@RequestMapping(value = "/grupo13/logingFormularioContr")
public class ArrendadorContrController {
    ArrendadorServiceContr arrendadorServiceContr;  
    @Autowired
    public ArrendadorContrController(ArrendadorServiceContr arrendadorServiceContr){
        this.arrendadorServiceContr = arrendadorServiceContr;
    }
        @PutMapping(value ="/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
        public ArrendadorDTOConr update(@RequestBody ArrendadorDTOConr arrendadorDTOConr){
        return arrendadorServiceContr.update(arrendadorDTOConr);
        }
}
