package com.example.trabajodegrado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.trabajodegrado.interfaces.EstadoModuloRepository;
import com.example.trabajodegrado.models.EstadoModulo;
import utils.exceptions.EstadoModuloException;

@Service
public class EstadoModuloService {

    private final EstadoModuloRepository estadoModuloRepository;

    @Autowired
    public EstadoModuloService(EstadoModuloRepository estadoModuloRepository) {
        this.estadoModuloRepository = estadoModuloRepository;
    }

    public Page<EstadoModulo> getEstadosModulo(PageRequest pageRequest) {
        return estadoModuloRepository.findAll(pageRequest);
    }

    public Page<EstadoModulo> getByIdEstadoModulo(PageRequest pageRequest, String idEstadoModulo) {
        if (idEstadoModulo == null) {
            return Page.empty();
        } else {
            Page<EstadoModulo> result = estadoModuloRepository.findByIdEstadoModulo(pageRequest, idEstadoModulo);

            if (result != null && result.hasContent()) {
                return result;
            } else {
                return Page.empty();
            }
        }
    }

    public Page<EstadoModulo> getByValorEstadoModulo(PageRequest pageRequest, String valorEstadoModulo) {
        if (valorEstadoModulo == null) {
            return Page.empty();
        } else {
            Page<EstadoModulo> result = estadoModuloRepository.findByValorEstadoModulo(pageRequest, valorEstadoModulo);

            if (result != null && result.hasContent()) {
                return result;
            } else {
                return Page.empty();
            }
        }
    }

    public EstadoModulo saveEstadoModulo(EstadoModulo newEstadoModulo, String idEstadoModulo, String valorEstadoModulo) {
        EstadoModulo existIdEstadoModulo = estadoModuloRepository.findByIdEstadoModulo(idEstadoModulo);
        EstadoModulo existValorEstadoModulo = estadoModuloRepository.findByValorEstadoModulo(valorEstadoModulo);

        if (existIdEstadoModulo != null) {
            throw new EstadoModuloException("Ya existe un estado modulo con el Id " + idEstadoModulo);
        } else if (existValorEstadoModulo != null) {
            throw new EstadoModuloException("Este nombre ya existe");
        } else {
            return estadoModuloRepository.save(newEstadoModulo);
        }
    }

    public EstadoModulo updateEstadoModulo(String idEstadoModulo, String valorEstadoModulo, EstadoModulo newEstadoModulo){
        EstadoModulo existIdEstadoModulo = estadoModuloRepository.findByIdEstadoModulo(idEstadoModulo);
        EstadoModulo existValorEstadoModulo = estadoModuloRepository.findByValorEstadoModulo(valorEstadoModulo);

        if (existIdEstadoModulo == null){
            throw new EstadoModuloException("No se encontro ningun estado modulo con el ID "+idEstadoModulo);
        } else if (existValorEstadoModulo != null) {
            throw new EstadoModuloException("El nombre del estado modulo ya existe");
        } else {
            existIdEstadoModulo.setIdEstadoModulo(newEstadoModulo.getIdEstadoModulo());
            existIdEstadoModulo.setValorEstadoModulo(newEstadoModulo.getValorEstadoModulo());
            estadoModuloRepository.save(existIdEstadoModulo);
            return existIdEstadoModulo;
        }
    }

    public EstadoModulo deleteEstadoModulo(String idEstadoModulo){
        EstadoModulo existIdEstadoModulo = estadoModuloRepository.findByIdEstadoModulo(idEstadoModulo);

        if (existIdEstadoModulo == null){
            throw new EstadoModuloException("No se encontro ningun estado modulo con el ID "+idEstadoModulo);
        } else {
            estadoModuloRepository.delete(existIdEstadoModulo);
            return existIdEstadoModulo;
        }
    }

}
