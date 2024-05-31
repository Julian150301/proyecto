package com.proyecto.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.proyecto.entity.Propiedades;

public interface PropiedadesRepsitory extends CrudRepository<Propiedades, Long>{
    List<Propiedades> findByIdArrendador(Long idArrendador);
}
