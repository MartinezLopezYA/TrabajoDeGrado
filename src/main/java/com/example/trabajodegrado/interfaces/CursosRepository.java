package com.example.trabajodegrado.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabajodegrado.models.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, String>{
    
}
