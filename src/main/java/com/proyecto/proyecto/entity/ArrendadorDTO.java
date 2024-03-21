package com.proyecto.proyecto.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrendadorDTO {
    private UUID uuid;

    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;
    private int telefono;
    private String contraseña;
    private int tipoCuenta;

}
