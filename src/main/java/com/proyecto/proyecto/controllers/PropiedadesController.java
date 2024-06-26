package com.proyecto.proyecto.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.PropiedadesDTO;
import com.proyecto.proyecto.services.PropiedadesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping(value = "/grupo13/logingFormularioPropiedades")
public class PropiedadesController {
    private final PropiedadesService propiedadesService;

    @Autowired
    public PropiedadesController(PropiedadesService propiedadesService) {
        this.propiedadesService = propiedadesService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadesDTO get(@PathVariable Long id) {
        return propiedadesService.get(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadesDTO> getAll() {
        return propiedadesService.getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadesDTO save(@RequestBody PropiedadesDTO propiedadesDTO) {
        return propiedadesService.save(propiedadesDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadesDTO update(@RequestBody PropiedadesDTO propiedadesDTO) {
        return propiedadesService.update(propiedadesDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        propiedadesService.delete(id);
    }

    // Nuevo endpoint para obtener propiedades por ID del arrendador
    @GetMapping(value = "/arrendador/{idArrendador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadesDTO> getByArrendadorId(@PathVariable Long idArrendador) {
        return propiedadesService.getByArrendadorId(idArrendador);
    }
}
