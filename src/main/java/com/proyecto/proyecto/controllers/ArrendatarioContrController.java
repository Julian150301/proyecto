package com.proyecto.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.ArrendadorDTOConr;
import com.proyecto.proyecto.dto.ArrendatarioDTOConr;
import com.proyecto.proyecto.services.ArrendadorServiceContr;
import com.proyecto.proyecto.services.ArrendatarioServiceContr;

@RestController
@RequestMapping(value = "/grupo13/logingFormularioArrendatarioContr")
public class ArrendatarioContrController {
    ArrendadorServiceContr arrendadorServiceContr;  
    @Autowired
    public  ArrendatarioContrController(ArrendatarioServiceContr arrendatarioServiceContr){
        this.arrendadorServiceContr = arrendadorServiceContr;
    }
        @PutMapping(value ="/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
        public ArrendatarioDTOConr update(@RequestBody ArrendatarioDTOConr arrendatarioDTOConr){
        return arrendatarioDTOConr.update(arrendatarioDTOConr);
        }
}
