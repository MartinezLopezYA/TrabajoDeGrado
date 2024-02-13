package com.example.trabajodegrado.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabajodegrado.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String>{
    
    public Curso findByNombreCurso(String nombreCurso);

}
