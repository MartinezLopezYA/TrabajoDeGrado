package com.example.trabajodegrado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.RolRepository;
import com.example.trabajodegrado.models.Rol;
import utils.exceptions.RolException;

@Service
public class RolService {
    
    private RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @SuppressWarnings("null")
    public Page<Rol> getRoles(PageRequest pageRequest) {
        return rolRepository.findAll(pageRequest);
    }

    @SuppressWarnings("null")
    public Rol saveRol(Rol newRol, String idRol, String nombreRol) {

        Rol existRolById = rolRepository.findByIdRol(idRol);
        Rol existRolByNombre = rolRepository.findByNombreRol(nombreRol);

        try {
            if (existRolById != null) {
                throw new RolException("Ya existe un Rol con el ID: " + idRol);
            } else if (existRolByNombre != null) {
                throw new RolException("Ya existe un Rol con el nombre: " + nombreRol);
            } else {
                return rolRepository.save(newRol);
            }
        } catch (RolException e) {
            throw new RolException("Error al guardar Rol " + e);
        }

    }

    public Rol deleteRol(String idRol) {

        Rol existRolById = rolRepository.findByIdRol(idRol);

        try {
            if (existRolById == null) {
                throw new RolException("No se encontró ningún Rol con el ID " + idRol);
            } else {
                rolRepository.delete(existRolById);
                return existRolById;
            }
        } catch (RolException e) {
            throw new RolException("Error al eliminar Rol " + e);
        }

    }

}
