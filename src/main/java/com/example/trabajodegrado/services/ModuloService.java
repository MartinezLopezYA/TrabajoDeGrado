package com.example.trabajodegrado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.ModuloRepository;
import com.example.trabajodegrado.models.Modulo;

import utils.exceptions.ModuloException;

@Service
public class ModuloService {
    
    private ModuloRepository moduloRepository;

    @Autowired
    public ModuloService(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @SuppressWarnings("null")
    public Page<Modulo> getModulos(PageRequest pageRequest) {
        return moduloRepository.findAll(pageRequest);
    }


    @SuppressWarnings("null")
    public Modulo saveModulo(Modulo newModulo, String idModulo) {

        Modulo existByIdModulo = moduloRepository.findByIdModulo(idModulo);

        try {
            if (existByIdModulo != null) {
                throw new ModuloException("Ya existe un modulo con ese codigo: " + idModulo);
            } else {
                return moduloRepository.save(newModulo);
            }
        } catch (ModuloException e) {
            throw new ModuloException("Error al guardar Modulo" + e);
        }  

    }

    public Modulo updateModulo(String idModulo, Modulo newModulo) {

        Modulo existModuloByIdModulo = moduloRepository.findByIdModulo(idModulo);

        try {
            if (existModuloByIdModulo == null) {
                throw new ModuloException("No se encontró ningún Modulo con el ID: " + idModulo);
            } else {
                existModuloByIdModulo.setNombreModulo(newModulo.getNombreModulo());
                existModuloByIdModulo.setDescripcionModulo(newModulo.getDescripcionModulo());
                moduloRepository.save(existModuloByIdModulo);
                return existModuloByIdModulo;
            }
        } catch (ModuloException e) {
            throw new ModuloException("Error al actualizar el Modulo" + e);
        }

    }

    @SuppressWarnings("null")
    public Modulo deleteModulo(String idModulo) {

        Modulo existModuloById = moduloRepository.findByIdModulo(idModulo);

        try {
            if (existModuloById != null) {
                throw new ModuloException("No se encontró ningún usuario con el ID: " + idModulo);
            } else {
                moduloRepository.delete(existModuloById);
                return existModuloById;
            }
        } catch (ModuloException e) {
            throw new ModuloException("Error al eliminar el Modulo " + e);
        }

    }

}
