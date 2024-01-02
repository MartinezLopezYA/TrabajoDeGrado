package com.example.trabajodegrado.impservices;

import java.util.*;

import com.example.trabajodegrado.models.EstadoCurso;

public interface IEstadoCursoService {

    public List<EstadoCurso> getEstadoCurso();
    Optional<EstadoCurso> editarEstadoCurso(String idEstadoCurso);
    public void guardarEstadoCurso(EstadoCurso estadoCurso);
    public void eliminarEstadoCurso(String idEstadoCurso);

}