package com.example.trabajodegrado.impservices;

import java.util.*;

import com.example.trabajodegrado.models.Rol;

public interface IRolService {
    
    public List<Rol> getRols();
    Optional<Rol> editarRol(String idRol);
    public void guardarRol(Rol rol);
    public void eliminarRol(String idRol);
    
}
