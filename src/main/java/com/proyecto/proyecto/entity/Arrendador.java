package com.proyecto.proyecto.entity;
import java.util.List;
import java.util.UUID;

import com.proyecto.proyecto.dto.PropiedadesDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Arrendador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;
    private int telefono;
    private String contrasena;
    private int tipoCuenta;

    @OneToMany(mappedBy = "arrendador")
    private List<Propiedades> propiedades; // Suponiendo que cada propiedad es representada por un objeto PropiedadDTO

    // Constructor, getters y setters

}