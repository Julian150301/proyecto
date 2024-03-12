package com.proyecto.proyecto.entity;
import java.util.UUID;

import org.hibernate.annotations.SQLDelete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE Arrendador SET status = WHERE id=?")


public class Arrendador {
    private UUID uuid;
    
    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;
    private int telefono;
    private String contraseña;
    private int tipoCuenta;
}
