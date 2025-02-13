package com.stevedev.clientesmservice.repositories;

import com.stevedev.clientesmservice.entitites.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    // Define una ruta qye permita buscar y devolver una lista de usuarios filtrados por su nombre
    List<ClienteEntity> findByNombreContainingIgnoreCase(String nombre);
    //Define una ruta que te devuelva la lista de todos los usuarios ordenados alfabéticamente
    List<ClienteEntity> findAllByOrderByNombreAsc();
}
