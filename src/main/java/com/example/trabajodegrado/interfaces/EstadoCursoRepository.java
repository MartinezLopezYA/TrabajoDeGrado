package com.example.trabajodegrado.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabajodegrado.models.EstadoCurso;

@Repository
public interface EstadoCursoRepository extends JpaRepository<EstadoCurso, String>{
    
}
