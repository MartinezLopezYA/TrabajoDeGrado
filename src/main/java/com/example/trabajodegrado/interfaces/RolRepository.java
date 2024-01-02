package com.example.trabajodegrado.interfaces;

import com.example.trabajodegrado.models.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, String>{

    public Rol findByIdRol(String idRol);
    public Rol findByNombreRol(String nombreRol);

}
