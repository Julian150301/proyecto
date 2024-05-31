package com.proyecto.proyecto.entity;

import com.proyecto.proyecto.dto.ArrendadorDTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Propiedades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idArrendador;
    private String nombre;
    private String municipio;
    private int cantidadPerosnas;
    private String departamento;
    private boolean reservada; 
    private String reservadaPor;

    @ManyToOne
    private Arrendador arrendador; // Agregar referencia al arrendador

    

}
