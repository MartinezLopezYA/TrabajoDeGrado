package com.example.trabajodegrado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.InsigniaRepository;
import com.example.trabajodegrado.models.Insignia;

import utils.exceptions.InsigniaException;

@Service
public class InsigniaService {

    private final InsigniaRepository insigniaRepository;

    @Autowired
    public InsigniaService(InsigniaRepository insigniaRepository) {
        this.insigniaRepository = insigniaRepository;
    }

    @SuppressWarnings("null")
    public Page<Insignia> getInsignias(PageRequest pageRequest) {
        return insigniaRepository.findAll(pageRequest);
    }

    public Page<Insignia> getByTituloInsignia(PageRequest pageRequest, String tituloInsignia) {

        Page<Insignia> existInsigniaByTitulo = insigniaRepository.findByTituloInsignia(pageRequest, tituloInsignia);

        if (existInsigniaByTitulo != null){
            return existInsigniaByTitulo;
        } else {
            throw new InsigniaException("No se encontró ninguna insignia con el titulo: " + tituloInsignia);
        }

    }

    @SuppressWarnings("null")
    public Insignia saveInsignia(Insignia newInsignia, int idInsignia) {

        Insignia existByIdInsignia = insigniaRepository.findByIdInsignia(idInsignia);

        if (existByIdInsignia != null) {
            throw new InsigniaException("Ya existe una Insignia con el ID: " + idInsignia);
        } else {
            return insigniaRepository.save(newInsignia);
        }

    }

    public Insignia updateInsignia(int idInsignia, Insignia newInsignia) {

        Insignia existInsigniaById = insigniaRepository.findByIdInsignia(idInsignia);

        if (existInsigniaById == null) {
            throw new InsigniaException("No se encontró la Insignia con el ID: " + idInsignia);
        } else {
            existInsigniaById.setTituloInsignia(newInsignia.getTituloInsignia());
            existInsigniaById.setFechaInsignia(newInsignia.getFechaInsignia());
            insigniaRepository.save(existInsigniaById);
            return existInsigniaById;
        }

    }

    public void deleteInsignia(int idInsignia) {

        Insignia existInsigniaById = insigniaRepository.findByIdInsignia(idInsignia);

        if (existInsigniaById == null) {
            throw new InsigniaException("No se encontró ninguna Insignia con el ID: " + idInsignia);
        } else {
            insigniaRepository.delete(existInsigniaById);
        }

    }

}
