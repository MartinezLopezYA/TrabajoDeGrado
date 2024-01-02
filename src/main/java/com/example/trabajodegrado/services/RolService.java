package com.example.trabajodegrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.RolRepository;
import com.example.trabajodegrado.models.Rol;

@Service
public class RolService {
    
    private RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    //Uso String porque no es necesario tener paginación por la cantidad de registros
    public String getRoles() {
        return "" + rolRepository.findAll();
    }

    public String saveRol(Rol newRol, String idRol, String nombreRol) {

        Optional<Rol> existById = rolRepository.findById(idRol);
        Rol existByNombreRol = rolRepository.findByNombreRol(nombreRol);

        try {
            if (rolRepository.existsById(idRol)) {
                return "Ya existe rol con ese codigo: " + existById.toString();
            } else if (existByNombreRol != null && existByNombreRol.getNombreRol().equals(newRol.getNombreRol())) {
                return "Ya existe rol con ese nombre: " + existByNombreRol.getNombreRol();
            } else {
                rolRepository.save(newRol);
                return "Rol registrado con exito";
            }
        } catch (Exception e) {
            return "Error al registrar el usuario " + e;
        }

    }

}
