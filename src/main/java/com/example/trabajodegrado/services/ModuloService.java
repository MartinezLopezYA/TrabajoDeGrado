package com.example.trabajodegrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.ModuloRepository;
import com.example.trabajodegrado.models.Modulo;

@Service
public class ModuloService {
    
    private ModuloRepository moduloRepository;

    @Autowired
    public ModuloService(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    public Page<Modulo> getModulos(PageRequest pageRequest) {
        return moduloRepository.findAll(pageRequest);
    }

    public String saveModulo(Modulo newModulo, String idModulo, String nombreModulo) {

        Optional<Modulo> existById = moduloRepository.findById(idModulo);
        Modulo existByNombreModulo = moduloRepository.findByNombreModulo(nombreModulo);

        try {
            if (moduloRepository.existsById(idModulo)) {
                return "Ya existe modulo con ese codigo: " + existById.toString();
            } else if (existByNombreModulo != null && existByNombreModulo.getNombreModulo().equals(newModulo.getNombreModulo())) {
                return "Ya existe modulo con ese nombre: " + existByNombreModulo.getNombreModulo();
            } else {
                moduloRepository.save(newModulo);
                return "Rol registrado con exito";
            }
        } catch (Exception e) {
            return "Error al registrar el modulo " + e;
        }

    }

    public String updateModulo(String idModulo, Modulo newModulo) {

        Optional<Modulo> existModulo = moduloRepository.findById(idModulo);

        try {
            if (existModulo.isPresent()) {

                Modulo exist = existModulo.get();

                exist.setNombreModulo(newModulo.getNombreModulo());
                exist.setDescripcionModulo(newModulo.getDescripcionModulo());

                moduloRepository.save(exist);

                return "Modulo actualizado con exito: \n" + exist.toString();

            } else {
                return "No existe ningún modulo con este Id";
            }
        } catch (Exception e) {
            return "Error al actualizar el modulo";
        }

    }

    public String deleteModulo(String idModulo) {

        try {
            Modulo modulo = moduloRepository.findById(idModulo).get();
            moduloRepository.delete(modulo);
            return "Registro eliminado de la tabla Modulo";
        } catch (Exception e) {
            return "No se pudo completar la ejecución de la tabla Modulo" + e;
        }

    }

}
