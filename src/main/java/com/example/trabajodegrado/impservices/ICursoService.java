package com.example.trabajodegrado.impservices;

import java.util.*;

import com.example.trabajodegrado.models.Curso;

public interface ICursoService {
    
    public List<Curso> getCurso();
    Optional<Curso> editarCurso(String idCurso);
    public void guardarCurso(Curso curso);
    public void eliminarCurso(String idCurso);
    
}
