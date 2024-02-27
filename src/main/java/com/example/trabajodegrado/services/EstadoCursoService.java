package com.example.trabajodegrado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.trabajodegrado.interfaces.EstadoCursoRepository;
import com.example.trabajodegrado.models.EstadoCurso;
import utils.exceptions.EstadoCursoException;

@Service
public class EstadoCursoService {

    private final EstadoCursoRepository estadoCursoRepository;

    @Autowired
    public EstadoCursoService(EstadoCursoRepository estadoCursoRepository) {
        this.estadoCursoRepository = estadoCursoRepository;
    }

    public Page<EstadoCurso> getEstadosCurso(PageRequest pageRequest) {
        return estadoCursoRepository.findAll(pageRequest);
    }

    public Page<EstadoCurso> getByIdEstadoCurso(PageRequest pageRequest, String idEstadoCurso) {
        if (idEstadoCurso == null) {
            return Page.empty();
        } else {
            Page<EstadoCurso> result = estadoCursoRepository.findByIdEstadoCurso(pageRequest, idEstadoCurso);

            if (result != null && result.hasContent()) {
                return result;
            } else {
                return Page.empty();
            }
        }
    }

    public Page<EstadoCurso> getByValorEstadoCurso(PageRequest pageRequest, String valorEstadoCurso) {
        if (valorEstadoCurso == null) {
            return Page.empty();
        } else {
            Page<EstadoCurso> result = estadoCursoRepository.findByValorEstadoCurso(pageRequest, valorEstadoCurso);

            if (result != null && result.hasContent()) {
                return result;
            } else {
                return Page.empty();
            }
        }
    }


    public EstadoCurso saveEstadoCurso(EstadoCurso newEstadoCurso, String idEstadoCurso, String valorEstadoCurso) {
        EstadoCurso existIdEstadoCurso = estadoCursoRepository.findByIdEstadoCurso(idEstadoCurso);
        EstadoCurso existValorEstadoCurso = estadoCursoRepository.findByValorEstadoCurso(valorEstadoCurso);

        if (existIdEstadoCurso != null) {
            throw new EstadoCursoException("Ya existe un estado curso con el Id " + idEstadoCurso);
        } else if (existValorEstadoCurso != null) {
            throw new EstadoCursoException("Este nombre ya existe");
        } else {
            return estadoCursoRepository.save(newEstadoCurso);
        }
    }

    public EstadoCurso updateEstadoCurso(String idEstadoCurso, String valorEstadoCurso, EstadoCurso newEstadoCurso){
        EstadoCurso existIdEstadoCurso = estadoCursoRepository.findByIdEstadoCurso(idEstadoCurso);
        EstadoCurso existValorEstadoCurso = estadoCursoRepository.findByValorEstadoCurso(valorEstadoCurso);

        if (existIdEstadoCurso == null){
            throw new EstadoCursoException("No se encontro ningun estado curso con el ID "+idEstadoCurso);
        } else if (existValorEstadoCurso != null) {
            throw new EstadoCursoException("El nombre del estado curso ya existe");
        } else {
            existIdEstadoCurso.setIdEstadoCurso(newEstadoCurso.getIdEstadoCurso());
            existIdEstadoCurso.setValorEstadoCurso(newEstadoCurso.getValorEstadoCurso());
            estadoCursoRepository.save(existIdEstadoCurso);
            return existIdEstadoCurso;
        }
    }

    public EstadoCurso deleteEstadoCurso(String idEstadoCurso){
        EstadoCurso existIdEstadoCurso = estadoCursoRepository.findByIdEstadoCurso(idEstadoCurso);

        if (existIdEstadoCurso == null){
            throw new EstadoCursoException("No se encontro ningun estado curso con el ID "+idEstadoCurso);
        } else {
            estadoCursoRepository.delete(existIdEstadoCurso);
            return existIdEstadoCurso;
        }
    }

}




