package com.example.trabajodegrado.impservices;

import java.util.*;

import com.example.trabajodegrado.models.Modulo;

public interface IModuloService {
    
    public List<Modulo> getModulo();
    Optional<Modulo> editarModulo(String idModulo);
    public void guardarModulo(Modulo modulo);
    public void eliminarModulo(String idModulo);

}
