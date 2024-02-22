package com.example.trabajodegrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.EstadoModuloRepository;
import com.example.trabajodegrado.models.EstadoModulo;

@Service
public class EstadoModuloService {
    
    private EstadoModuloRepository estadoModuloRepository;

    @Autowired
    public EstadoModuloService(EstadoModuloRepository estadoModuloRepository) {
        this.estadoModuloRepository = estadoModuloRepository;
    }

    @SuppressWarnings("null")
    public Page<EstadoModulo> getEstadosModulo(PageRequest pageRequest) {
        return estadoModuloRepository.findAll(pageRequest);
    }

    @SuppressWarnings("null")
    public String saveEstadoModulo(EstadoModulo newEstadoModulo, String idEstadoModulo) {

        Optional<EstadoModulo> existById = estadoModuloRepository.findById(idEstadoModulo);

        try {
            if (estadoModuloRepository.existsById(idEstadoModulo)) {
                return "Ya existe el estado con ese codigo: " + existById.toString();
            } else {
                estadoModuloRepository.save(newEstadoModulo);
                return "Estado registrado con exito";
            }
        } catch (Exception e) {
            return "Error al registrar el EstadoModulo " + e;
        }

    }

}
