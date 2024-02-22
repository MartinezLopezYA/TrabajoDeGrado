package com.example.trabajodegrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.EstadoCursoRepository;
import com.example.trabajodegrado.models.EstadoCurso;

@Service
public class EstadoCursoService {
    
    private EstadoCursoRepository estadoCursoRepository;

    @Autowired
    public EstadoCursoService(EstadoCursoRepository estadoCursoRepository) {
        this.estadoCursoRepository = estadoCursoRepository;
    }

    @SuppressWarnings("null")
    public Page<EstadoCurso> getEstadosCurso(PageRequest pageRequest) {
        return estadoCursoRepository.findAll(pageRequest);
    }

    @SuppressWarnings("null")
    public String saveEstadoCurso(EstadoCurso newEstadoCurso, String idEstadoCurso) {

        Optional<EstadoCurso> existById = estadoCursoRepository.findById(idEstadoCurso);

        try {
            if (estadoCursoRepository.existsById(idEstadoCurso)) {
                return "Ya existe el estado con ese codigo: " + existById.toString();
            } else {
                estadoCursoRepository.save(newEstadoCurso);
                return "Estado registrado con exito";
            }
        } catch (Exception e) {
            return "Error al registrar el EstadoCurso " + e;
        }

    }

}
