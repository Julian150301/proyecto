package com.proyecto.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.proyecto.proyecto.entity.Arrendador;
import com.proyecto.proyecto.entity.Arrendatario;

public interface ArrendatarioRepositoryContr extends CrudRepository<Arrendatario, Long>{
    @Query("SELECT u FROM Arrendador u WHERE u.correo = :nombre AND u.contrasena = getSHA1(:contrasena)")
    public Arrendador loging(@Param("nombre")String nombre, @Param("contrasena")String contrasena);

    @Query("SELECT u FROM Arrendador u WHERE u.correo = :correo")
    public List<Arrendador>findBycorreo(@Param("correo")String correo);
}
