package com.proyecto.proyecto.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.ArrendadorDTO;
import com.proyecto.proyecto.dto.PropiedadesDTO;
import com.proyecto.proyecto.entity.Arrendador;
import com.proyecto.proyecto.entity.Propiedades;
import com.proyecto.proyecto.services.ArrendadorService;
import com.proyecto.proyecto.services.PropiedadesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping(value = "/grupo13/logingFormularioPropiedades")
public class PropiedadesController {
    private final PropiedadesService propiedadesService;
    private final ArrendadorService arrendadorService;

    @Autowired
    public PropiedadesController(PropiedadesService propiedadesService,ArrendadorService arrendadorService) {
        this.propiedadesService = propiedadesService;
        this.arrendadorService = arrendadorService;
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

    @PostMapping(value = "/reservar/{idArrendador}/{idPropiedad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> reservarPropiedad(@PathVariable Long idPropiedad, @PathVariable Long idArrendador) {
        Propiedades propiedad = propiedadesService.getById(idPropiedad);
        Arrendador arrendador = arrendadorService.getById(idArrendador);
        
        if (propiedad == null || arrendador == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Verificar que la propiedad pertenece al arrendador
        if (!arrendador.getPropiedades().contains(propiedad)) {
            return ResponseEntity.badRequest().body("La propiedad no pertenece al arrendador.");
        }
        
        // Realizar la reserva
        propiedad.setReservada(true);
        propiedad.setReservadaPor(arrendador.getNombre());
        propiedadesService.save(propiedad);
        
        return ResponseEntity.ok("Propiedad reservada exitosamente por el arrendador: " + arrendador.getNombre());
    }
}
