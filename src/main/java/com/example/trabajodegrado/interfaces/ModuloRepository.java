package com.example.trabajodegrado.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabajodegrado.models.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, String>{
    
    public Modulo findByNombreModulo(String nombreModulo);

}
