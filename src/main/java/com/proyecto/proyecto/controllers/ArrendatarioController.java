package com.proyecto.proyecto.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.ArrendatarioDTO;
import com.proyecto.proyecto.services.ArrendatarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/grupo13/logingFormularioArrendatario")
public class ArrendatarioController {
    private final ArrendatarioService arrendatarioService;

    @Autowired
    public ArrendatarioController(ArrendatarioService arrendatarioService) {
        this.arrendatarioService = arrendatarioService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO get(@PathVariable Long id) {
        return arrendatarioService.get(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArrendatarioDTO> getAll() {
        return arrendatarioService.getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO save(@RequestBody ArrendatarioDTO arrendatarioDTO) {
        return arrendatarioService.save(arrendatarioDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO update(@RequestBody ArrendatarioDTO arrendatarioDTO) {
        return arrendatarioService.update(arrendatarioDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        arrendatarioService.delete(id);
    }
}

