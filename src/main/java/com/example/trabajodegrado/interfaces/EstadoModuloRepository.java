package com.example.trabajodegrado.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabajodegrado.models.EstadoModulo;

@Repository
public interface EstadoModuloRepository extends JpaRepository<EstadoModulo, String>{
    
    public EstadoModulo findByIdEstadoModulo(String idEstadoModulo);

}
