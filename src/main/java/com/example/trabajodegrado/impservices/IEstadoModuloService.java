package com.example.trabajodegrado.impservices;

import java.util.*;

import com.example.trabajodegrado.models.EstadoModulo;

public interface IEstadoModuloService {
    
    public List<EstadoModulo> getEstadoModulo();
    Optional<EstadoModulo> editarEstadoModulo(String idEstadoModulo);
    public void guardarEstadoModulo(EstadoModulo estadoModulo);
    public void eliminarEstadoModulo(String idEstadoModulo);
    
}
